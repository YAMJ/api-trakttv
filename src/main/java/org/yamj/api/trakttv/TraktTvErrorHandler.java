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

import org.yamj.api.common.exception.ApiExceptionType;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TraktTvErrorHandler implements ErrorHandler {

    @Override
    public Throwable handleError(RetrofitError cause) {
        Response r = cause.getResponse();
        if (r == null) {
            return new TraktTvException(ApiExceptionType.UNKNOWN_CAUSE, cause.getMessage());
        }

        switch (r.getStatus()) {
            case 401:
                return new TraktTvException(ApiExceptionType.AUTH_FAILURE, "No valid OAuth token provided", r.getStatus(), r.getUrl());
            case 403:
                return new TraktTvException(ApiExceptionType.AUTH_FAILURE, "No valid client ID provided", r.getStatus(), r.getUrl());
            case 404:
                return new TraktTvException(ApiExceptionType.HTTP_404_ERROR, cause.getMessage(), r.getStatus(), r.getUrl(), cause);
            case 503:
                return new TraktTvException(ApiExceptionType.HTTP_503_ERROR, cause.getMessage(), r.getStatus(), r.getUrl(), cause);
            default:
                return new TraktTvException(ApiExceptionType.UNKNOWN_CAUSE, cause.getMessage(), r.getStatus(), r.getUrl(), cause);
        }
    }
}
