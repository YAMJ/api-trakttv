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
import org.yamj.api.trakttv.model.Episode;
import org.yamj.api.trakttv.model.Ratings;
import org.yamj.api.trakttv.model.Season;
import org.yamj.api.trakttv.model.enumeration.Extended;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface SeasonService {

    @GET("/shows/{id}/seasons")
    List<Season> getSeasons(@Path("id") String id);

    @GET("/shows/{id}/seasons/{season}/ratings")
    Ratings getRatings(@Path("id") String id, @Path("season") Integer season);

    @GET("/shows/{id}/seasons/{season}")
    List<Episode> getEpisodes(@Path("id") String id, @Path("season") Integer season,
                    @Query(value = "extended", encodeValue = false) Extended extended);
}
