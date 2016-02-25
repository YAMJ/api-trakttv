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

@JsonInclude(Include.NON_DEFAULT)
public class Airs extends AbstractJsonMapping {

    private static final long serialVersionUID = -1048429605438186837L;

    @JsonProperty("day")
    private String airsDay;
    @JsonProperty("time")
    private String airsTime;
    @JsonProperty("timezone")
    private String airsTimezone;

    public String getAirsDay() {
        return airsDay;
    }

    public void setAirsDay(String airsDay) {
        this.airsDay = airsDay;
    }

    public String getAirsTime() {
        return airsTime;
    }

    public void setAirsTime(String airsTime) {
        this.airsTime = airsTime;
    }

    public String getAirsTimezone() {
        return airsTimezone;
    }

    public void setAirsTimezone(String airsTimezone) {
        this.airsTimezone = airsTimezone;
    }

}
