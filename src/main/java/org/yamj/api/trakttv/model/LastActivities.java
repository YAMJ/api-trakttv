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

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.joda.time.DateTime;

@JsonRootName("lastActivities")
@JsonInclude(Include.NON_DEFAULT)
public class LastActivities extends AbstractJsonMapping {

    private static final long serialVersionUID = 2756741955911197181L;

    @JsonProperty("all")
    public DateTime all;
    @JsonProperty("movies")
    public LastActivity movies;
    @JsonProperty("episodes")
    public LastActivity episodes;
    @JsonProperty("shows")
    public LastActivity shows;
    @JsonProperty("seasons")
    public LastActivity seasons;

    public DateTime getAll() {
        return all;
    }

    public void setAll(DateTime all) {
        this.all = all;
    }

    public LastActivity getMovies() {
        return movies;
    }

    public void setMovies(LastActivity movies) {
        this.movies = movies;
    }

    public LastActivity getEpisodes() {
        return episodes;
    }

    public void setEpisodes(LastActivity episodes) {
        this.episodes = episodes;
    }

    public LastActivity getShows() {
        return shows;
    }

    public void setShows(LastActivity shows) {
        this.shows = shows;
    }

    public LastActivity getSeasons() {
        return seasons;
    }

    public void setSeasons(LastActivity seasons) {
        this.seasons = seasons;
    }
}
