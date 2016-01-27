package org.yamj.api.trakttv.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class TokenResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("created_at")
    private Integer createdAt;
    @JsonProperty("scope")
    private String scope;
    
    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public String getScope() {
        return scope;
    }
}
