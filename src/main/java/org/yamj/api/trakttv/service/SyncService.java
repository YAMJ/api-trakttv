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
package org.yamj.api.trakttv.service;

import java.util.List;
import org.yamj.api.trakttv.model.*;
import org.yamj.api.trakttv.model.enumeration.Extended;
import retrofit.http.*;

/**
 * Note that for all request an authorization is required via OAuth and access_token.
 */
public interface SyncService {

    @GET("/sync/last_activities")
    LastActivities getLastActivities();

    @GET("/sync/collection/movies")
    List<TrackedMovie> getCollectionMovies(@Query(value = "extended", encodeValue = false) Extended extended);

    @GET("/sync/collection/shows")
    List<TrackedShow> getCollectionShows(@Query(value = "extended", encodeValue = false) Extended extended);

    @POST("/sync/collection")
    SyncResponse addItemsToCollection(@Body SyncItems items);

    @POST("/sync/collection/remove")
    SyncResponse deleteItemsFromCollection(@Body SyncItems items);
    
    @GET("/sync/watched/movies")
    List<TrackedMovie> getWatchedMovies(@Query(value = "extended", encodeValue = false) Extended extended);

    @GET("/sync/watched/shows")
    List<TrackedShow> getWatchedShows(@Query(value = "extended", encodeValue = false) Extended extended);

    @POST("/sync/history")
    SyncResponse addItemsToWatchedHistory(@Body SyncItems items);

    @POST("/sync/history/remove")
    SyncResponse deleteItemsFromWatchedHistory(@Body SyncItems items);
}