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
import java.util.Date;
import org.joda.time.DateTime;

@JsonInclude(Include.NON_DEFAULT)
public class SyncMovie extends AbstractJsonMapping {

    private static final long serialVersionUID = 8863410754213636522L;
    
    @JsonProperty("ids")
    private Ids ids;
    @JsonProperty("collected_at")
    private DateTime collectedAt;
    @JsonProperty("watched_at")
    private DateTime watchedAt;

    public Ids ids() {
        return ids;
    }
    
    public SyncMovie ids(Ids ids) {
        this.ids = ids;
        return this;
    }

    public SyncMovie collectedAt(Date collectedAt) {
        if (collectedAt == null) {
            this.collectedAt = null;
            return this;
        }
        return this.collectedAt(new DateTime(collectedAt.getTime()));
    }

    public SyncMovie collectedAt(DateTime collectedAt) {
        this.collectedAt = collectedAt;
        return this;
    }

    public SyncMovie watchedAt(Date watchedAt) {
        if (watchedAt == null) {
            this.watchedAt = null;
            return this;
        }
        return this.watchedAt(new DateTime(watchedAt.getTime()));
    }

    public SyncMovie watchedAt(DateTime watchedAt) {
        this.watchedAt = watchedAt;
        return this;
    }
}
