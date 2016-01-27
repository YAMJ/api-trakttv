package org.yamj.api.trakttv.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class PinRequestBody {

    @JsonProperty("code")
    private String code;
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("client_secret")
    private String clientSecret;
    @JsonProperty("redirect_uri")
    private String redirectUri = "urn:ietf:wg:oauth:2.0:oob";
    @JsonProperty("grant_type")
    private String grantType = "authorization_code";

    public void setCode(String code) {
        this.code = code;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
