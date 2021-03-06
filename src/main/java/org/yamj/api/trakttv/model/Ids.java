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

@JsonRootName("ids")
@JsonInclude(Include.NON_DEFAULT)
public class Ids extends AbstractJsonMapping {

    private static final long serialVersionUID = 1209919474502206694L;

    @JsonProperty("trakt")
    private Integer trakt;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("imdb")
    private String imdb;
    @JsonProperty("tmdb")
    private Integer tmdb;
    @JsonProperty("tvdb")
    private Integer tvdb;
    @JsonProperty("tvrage")
    private String tvRage;

    public Integer trakt() {
        return trakt;
    }

    public Ids trakt(Integer trakt) {
        this.trakt = trakt;
        return this;
    }

    public String slug() {
        return slug;
    }

    public Ids slug(String slug) {
        this.slug = slug;
        return this;
    }

    public String imdb() {
        return imdb;
    }

    public Ids imdb(String imdb) {
        this.imdb = imdb;
        return this;
    }

    public Integer tmdb() {
        return tmdb;
    }

    public Ids tmdb(Integer tmdb) {
        this.tmdb = tmdb;
        return this;
    }
    
    public Integer tvdb() {
        return tvdb;
    }

    public Ids tvdb(Integer tvdb) {
        this.tvdb = tvdb;
        return this;
    }

    public String tvRage() {
        return tvRage;
    }

    public Ids tvRage(String tvRage) {
        this.tvRage = tvRage;
        return this;
    }
}
