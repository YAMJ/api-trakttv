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
import org.yamj.api.trakttv.model.SearchResult;
import org.yamj.api.trakttv.model.enumeration.IdType;
import org.yamj.api.trakttv.model.enumeration.SearchType;
import retrofit.http.GET;
import retrofit.http.Query;

public interface SearchService {

    @GET("/search")
    List<SearchResult> textSearch(@Query("query") String query, @Query("type") SearchType type, @Query("year") Integer year);

    @GET("/search")
    List<SearchResult> textSearch(@Query("query") String query, @Query("type") SearchType type, @Query("year") Integer year,
                    @Query("page") Integer page, @Query("limit") Integer limit);

    @GET("/search")
    List<SearchResult> idSearch(@Query(value = "id_type", encodeValue = false) IdType idType,
                    @Query(value = "id", encodeValue = false) String id);

    @GET("/search")
    List<SearchResult> idSearch(@Query(value = "id_type", encodeValue = false) IdType idType,
                    @Query(value = "id", encodeValue = false) String id, @Query("page") Integer page, @Query("limit") Integer limit);
}
