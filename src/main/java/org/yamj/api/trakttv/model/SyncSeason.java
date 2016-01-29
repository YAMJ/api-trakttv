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
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

@JsonInclude(Include.NON_DEFAULT)
public class SyncSeason extends AbstractJsonMapping {

    private static final long serialVersionUID = -404329921496126032L;
    
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("episodes")
    private List<SyncEpisode> episodes = new ArrayList<>();
    @JsonProperty("collected_at")
    private DateTime collectedAt;
    @JsonProperty("watched_at")
    private DateTime watchedAt;

    public SyncSeason number(int number) {
        this.number = number;
        return this;
    }

    public SyncSeason episode(SyncEpisode episode) {
        this.episodes.add(episode);
        return this;
    }

    public SyncSeason episodes(List<SyncEpisode> episodes) {
        this.episodes.addAll(episodes);
        return this;
    }

    public SyncSeason collectedAt(DateTime collectedAt) {
        this.collectedAt = collectedAt;
        return this;
    }

    public SyncSeason watchedAt(DateTime watchedAt) {
        this.watchedAt = watchedAt;
        return this;
    }
}
