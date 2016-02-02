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

@JsonRootName("episode")
@JsonInclude(Include.NON_DEFAULT)
public class Episode extends AbstractBaseMapping {

    private static final long serialVersionUID = -778163115746225871L;

    @JsonProperty("season")
    private Integer season;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("number_abs")
    private Integer absoluteNumber;
    @JsonProperty("first_aired")
    private DateTime firstAired;

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAbsoluteNumber() {
        return absoluteNumber;
    }

    public void setAbsoluteNumber(Integer absoluteNumber) {
        this.absoluteNumber = absoluteNumber;
    }

    public DateTime getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(DateTime firstAired) {
        this.firstAired = firstAired;
    }
}
