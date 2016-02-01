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
import java.util.List;

@JsonInclude(Include.NON_DEFAULT)
public class SyncErrors extends AbstractJsonMapping {

    private static final long serialVersionUID = -5898965470625711227L;

    @JsonProperty("movies")
    private List<SyncMovie> movies;
    @JsonProperty("shows")
    private List<SyncShow> shows;
    @JsonProperty("seasons")
    private List<SyncSeason> seasons;
    @JsonProperty("episodes")
    private List<SyncEpisode> episodes;
    @JsonProperty("ids")
    private List<Integer> ids;

    public List<SyncMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<SyncMovie> movies) {
        this.movies = movies;
    }

    public List<SyncShow> getShows() {
        return shows;
    }

    public void setShows(List<SyncShow> shows) {
        this.shows = shows;
    }

    public List<SyncSeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<SyncSeason> seasons) {
        this.seasons = seasons;
    }

    public List<SyncEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<SyncEpisode> episodes) {
        this.episodes = episodes;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
