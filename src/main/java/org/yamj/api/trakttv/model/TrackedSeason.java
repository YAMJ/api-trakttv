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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TrackedSeason extends AbstractJsonMapping {

    private static final long serialVersionUID = 4628880445255761591L;
    
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("episodes")
    public List<TrackedEpisode> episodes;
    @JsonProperty("aired")
    public Integer aired;
    @JsonProperty("completed")
    public Integer completed;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<TrackedEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<TrackedEpisode> episodes) {
        this.episodes = episodes;
    }

    public Integer getAired() {
        return aired;
    }

    public void setAired(Integer aired) {
        this.aired = aired;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }
}
