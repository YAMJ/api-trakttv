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
package org.yamj.api.trakttv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

@JsonInclude(Include.NON_DEFAULT)
public class SyncItems {

    @JsonProperty("movies")
    private List<SyncMovie> movies;
    @JsonProperty("shows")
    private List<SyncShow> shows;
    @JsonProperty("episodes")
    private List<SyncEpisode> episodes;
    @JsonProperty("ids")
    private List<Integer> ids;

    public SyncItems movie(SyncMovie movie) {
        this.movies = Collections.singletonList(movie);
        return this;
    }

    public SyncItems movies(List<SyncMovie> movies) {
        this.movies = movies;
        return this;
    }

    public SyncItems show(SyncShow show) {
        this.shows = Collections.singletonList(show);
        return this;
    }

    public SyncItems shows(List<SyncShow> shows) {
        this.shows = shows;
        return this;
    }

    public SyncItems episode(SyncEpisode episode) {
        this.episodes = Collections.singletonList(episode);
        return this;
    }

    public SyncItems episodes(List<SyncEpisode> episodes) {
        this.episodes = episodes;
        return this;
    }

    public SyncItems ids(int id) {
        this.ids = Collections.singletonList(id);
        return this;
    }

    public SyncItems ids(List<Integer> ids) {
        this.ids = ids;
        return this;
    }
}
