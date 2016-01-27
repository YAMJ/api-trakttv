/*
 *      Copyright (c) 2015-2016 YAMJ Members
 *      https://github.com/orgs/YAMJ/people
 *
 *      This file is part of the TraktTV API.
 *
 *      The API is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The API is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the API.  If not, see <http://www.gnu.org/licenses/>.
 *
 *      Web: https://github.com/YAMJ/api-trakttv
 */
package org.yamj.api.trakttv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.exception.ApiExceptionType;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;
import org.yamj.api.common.http.SimpleHttpClientBuilder;
import org.yamj.api.trakttv.auth.TokenRequest;
import org.yamj.api.trakttv.auth.TokenResponse;
import org.yamj.api.trakttv.service.*;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.ApacheClient;
import retrofit.converter.JacksonConverter;

/**
 * Implementation for TraktTV API
 *
 * @author modmax
 */
public class TraktTvApi {

    private static final Logger LOG = LoggerFactory.getLogger(TraktTvApi.class);
    
    private static final String TRAKT_API_URL = "https://api-v2launch.trakt.tv";
    private static final String TRAKT_TOKEN_URL = TRAKT_API_URL + "/oauth/token";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_TRAKT_API_KEY = "trakt-api-key";
    private static final String HEADER_TRAKT_API_VERSION = "trakt-api-version";
    private static final String HEADER_TRAKT_API_VERSION_2 = "2";

    private final String clientId;
    private final String clientSecret;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final Charset UTF8 = Charset.forName("UTF-8");

    private String accessToken;
    private boolean isDebug;
    private RestAdapter restAdapter;
    
    /**
     * Create the API
     * 
     * @param clientId the client ID
     * @param clientSecret the client secret
     */
    public TraktTvApi(final String clientId, final String clientSecret) {
        this(clientId, clientSecret, new SimpleHttpClientBuilder().build());
    }
    
    /**
     * Create the API
     *
     * @param clientId the client ID
     * @param clientSecret the client secret
     * @param httpClient the HTTP client to use for requesting web pages
     */
    public TraktTvApi(final String clientId, final String clientSecret, final HttpClient httpClient) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper().registerModule(new JodaModule());
    }

    public TraktTvApi setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        restAdapter = null;
        return this;
    }
    
    public TraktTvApi setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;

        if (restAdapter != null) {
            restAdapter.setLogLevel(isDebug ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE);
        }

        return this;
    }
    
    protected RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(TRAKT_API_URL)
                .setClient(new ApacheClient(httpClient))
                .setConverter(new JacksonConverter(objectMapper))
                .setErrorHandler(new TraktTvErrorHandler())
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        if (accessToken != null && accessToken.length() != 0) {
                            request.addHeader(HEADER_AUTHORIZATION, "Bearer" + " " + accessToken);
                        }
                        request.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
                        request.addHeader(HEADER_TRAKT_API_KEY, clientId);
                        request.addHeader(HEADER_TRAKT_API_VERSION, HEADER_TRAKT_API_VERSION_2);
                    }
                });

            if (isDebug) {
                builder.setLogLevel(RestAdapter.LogLevel.FULL);
            }

            restAdapter = builder.build();
        }

        return restAdapter;
    }
    
    // AUTHORIZATION
    
    public TokenResponse requestAccessTokenByPin(final String pin) throws TraktTvException {
        StringEntity body;
        try {
            TokenRequest request = new TokenRequest();
            request.setClientId(clientId);
            request.setClientSecret(clientSecret);
            request.setCode(pin);
            request.setGrantType("authorization_code");
            request.setRedirectUri("urn:ietf:wg:oauth:2.0:oob");
            body = new StringEntity(objectMapper.writeValueAsString(request), UTF8);
        } catch (Exception e) {
            throw new TraktTvException(ApiExceptionType.MAPPING_FAILED, "Failed to build request body");
        }
            
        LOG.debug("Request authorization via PIN");
        
        try {
            HttpPost httpPost = new HttpPost();
            httpPost.setURI(new URI(TRAKT_TOKEN_URL));
            httpPost.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            httpPost.setEntity(body);
            
            DigestedResponse digestedResponse = DigestedResponseReader.postContent(httpClient, httpPost, UTF8);
            switch(digestedResponse.getStatusCode()) {
            case 200:
                return objectMapper.readValue(digestedResponse.getContent(), TokenResponse.class);
            case 401:
                throw new TraktTvException(ApiExceptionType.AUTH_FAILURE, "Invalid PIN provided", 401, "");
            case 403:
                throw new TraktTvException(ApiExceptionType.AUTH_FAILURE, "Invalid client credentials", 403, "");
            default:
                throw new TraktTvException(ApiExceptionType.UNKNOWN_CAUSE, "Unknown error", digestedResponse.getStatusCode(), "");
            }
        } catch (URISyntaxException | IOException e) {
            throw new TraktTvException(ApiExceptionType.MAPPING_FAILED, "Failed to access Trakt.TV");
        }
    }
    
    // SERVICES
    
    public MovieService movieService() {
        return getRestAdapter().create(MovieService.class);
    }

    public ShowService showService() {
        return getRestAdapter().create(ShowService.class);
    }

    public SeasonService seasonService() {
        return getRestAdapter().create(SeasonService.class);
    }

    public EpisodeService episodeService() {
        return getRestAdapter().create(EpisodeService.class);
    }
}
