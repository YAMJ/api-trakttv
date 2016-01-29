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
import org.joda.time.DateTime;

public class TrackedEpisode extends AbstractJsonMapping {

    private static final long serialVersionUID = 2992185219379302398L;
    
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("collected_at")
    public DateTime collectedAt;
    @JsonProperty("plays")
    public Integer plays;
    @JsonProperty("last_watched_at")
    public DateTime lastWatchedAt;
    @JsonProperty("completed")
    public Boolean completed;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public DateTime getCollectedAt() {
        return collectedAt;
    }

    public void setCollectedAt(DateTime collectedAt) {
        this.collectedAt = collectedAt;
    }

    public Integer getPlays() {
        return plays;
    }

    public void setPlays(Integer plays) {
        this.plays = plays;
    }

    public DateTime getLastWatchedAt() {
        return lastWatchedAt;
    }

    public void setLastWatchedAt(DateTime lastWatchedAt) {
        this.lastWatchedAt = lastWatchedAt;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
