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
import org.joda.time.DateTime;

@JsonInclude(Include.NON_DEFAULT)
public class LastActivity extends AbstractJsonMapping {

    private static final long serialVersionUID = 9104360795837605387L;

    @JsonProperty("rated_at")
    private DateTime ratedAt;
    @JsonProperty("watchlisted_at")
    private DateTime watchlistedAt;
    @JsonProperty("commented_at")
    private DateTime commentedAt;
    @JsonProperty("watched_at")
    private DateTime watchedAt;
    @JsonProperty("collected_at")
    private DateTime collectedAt;

    public DateTime getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(DateTime ratedAt) {
        this.ratedAt = ratedAt;
    }

    public DateTime getWatchlistedAt() {
        return watchlistedAt;
    }

    public void setWatchlistedAt(DateTime watchlistedAt) {
        this.watchlistedAt = watchlistedAt;
    }

    public DateTime getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(DateTime commentedAt) {
        this.commentedAt = commentedAt;
    }

    public DateTime getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(DateTime watchedAt) {
        this.watchedAt = watchedAt;
    }

    public DateTime getCollectedAt() {
        return collectedAt;
    }

    public void setCollectedAt(DateTime collectedAt) {
        this.collectedAt = collectedAt;
    }
}
