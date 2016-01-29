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
import org.joda.time.DateTime;

@JsonInclude(Include.NON_DEFAULT)
public class TrackedShow extends AbstractJsonMapping {

    private static final long serialVersionUID = 7385737341624191326L;
    
    @JsonProperty("show")
    private Show show;
    @JsonProperty("seasons")
    private List<TrackedSeason> seasons;
    @JsonProperty("last_collected_at")
    private DateTime lastCollectedAt;
    @JsonProperty("listed_at")
    private DateTime listedAt;
    @JsonProperty("plays")
    private Integer plays;
    @JsonProperty("last_watched_at")
    private DateTime lastWatchedAt;
    @JsonProperty("aired")
    private Integer aired;
    @JsonProperty("completed")
    private Integer completed;
    @JsonProperty("hidden_seasons")
    private List<Season> hiddenSeasons;
    @JsonProperty("next_episode")
    private Episode nextEpisode;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<TrackedSeason> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<TrackedSeason> seasons) {
        this.seasons = seasons;
    }

    public DateTime getLastCollectedAt() {
        return lastCollectedAt;
    }

    public void setLastCollectedAt(DateTime lastCollectedAt) {
        this.lastCollectedAt = lastCollectedAt;
    }

    public DateTime getListedAt() {
        return listedAt;
    }

    public void setListedAt(DateTime listedAt) {
        this.listedAt = listedAt;
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

    public List<Season> getHiddenSeasons() {
        return hiddenSeasons;
    }

    public void setHiddenSeasons(List<Season> hiddenSeasons) {
        this.hiddenSeasons = hiddenSeasons;
    }

    public Episode getNextEpisode() {
        return nextEpisode;
    }

    public void setNextEpisode(Episode nextEpisode) {
        this.nextEpisode = nextEpisode;
    }
}
