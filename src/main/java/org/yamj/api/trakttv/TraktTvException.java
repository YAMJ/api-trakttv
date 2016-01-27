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

import java.net.URL;
import org.yamj.api.common.exception.ApiExceptionType;

/**
 * Exception for API Classes to use
 */
public class TraktTvException extends RuntimeException {

    private static final long serialVersionUID = -5569133828890286845L;
    
    private final ApiExceptionType exceptionType;
    private final String response;
    private final int responseCode;
    private final String url;

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response) {
        this(exceptionType, response, 0, "");
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param url The URL that cause the exception or is associated with it
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final URL url) {
        this(exceptionType, response, 0, url.toExternalForm());
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param responseCode A response code, such as the HTTP status from a web
     * request
     * @param url The URL that cause the exception or is associated with it
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final URL url) {
        this(exceptionType, response, responseCode, url.toExternalForm());
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param url The URL that cause the exception or is associated with it
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final String url) {
        this(exceptionType, response, 0, url);
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param responseCode A response code, such as the HTTP status from a web
     * request
     * @param url The URL that cause the exception or is associated with it
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final String url) {
        super("ExceptionType=" + exceptionType + ", ResponseCode=" + responseCode + ", URL=" + url);
        this.exceptionType = exceptionType;
        this.response = response;
        this.responseCode = responseCode;
        this.url = url;
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param url The URL that cause the exception or is associated with it
     * @param cause The underlying exception that was the cause of this API
     * Exception
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final URL url, final Throwable cause) {
        this(exceptionType, response, 0, url.toExternalForm(), cause);
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param responseCode A response code, such as the HTTP status from a web
     * request
     * @param url The URL that cause the exception or is associated with it
     * @param cause The underlying exception that was the cause of this API
     * Exception
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final URL url, final Throwable cause) {
        this(exceptionType, response, responseCode, url.toExternalForm(), cause);
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param url The URL that cause the exception or is associated with it
     * @param cause The underlying exception that was the cause of this API
     * Exception
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final String url, final Throwable cause) {
        this(exceptionType, response, 0, url, cause);
    }

    /**
     * Generate an API exception
     *
     * @param exceptionType The type of the exception to throw
     * @param response A response message associated with the exception
     * @param responseCode A response code, such as the HTTP status from a web
     * request
     * @param url The URL that cause the exception or is associated with it
     * @param cause The underlying exception that was the cause of this API
     * Exception
     */
    public TraktTvException(final ApiExceptionType exceptionType, final String response, final int responseCode, final String url, final Throwable cause) {
        super("ExceptionType=" + exceptionType + ", ResponseCode=" + responseCode + ", URL=" + url, cause);
        this.exceptionType = exceptionType;
        this.response = response;
        this.responseCode = responseCode;
        this.url = url;
    }

    /**
     * The enumerated type of the exception
     *
     * @return The exception type
     */
    public ApiExceptionType getExceptionType() {
        return exceptionType;
    }

    /**
     * The response message associated with the exception
     *
     * @return The response message
     */
    public String getResponse() {
        return response;
    }

    /**
     * The response code, such as the HTTP status from a web request
     *
     * @return The response code
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * The URL that cause the exception or is associated with it
     *
     * @return the URL
     */
    public String getUrl() {
        return url;
    }
}
