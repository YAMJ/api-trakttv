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
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("images")
public class Images extends AbstractJsonMapping {

    private static final long serialVersionUID = 8364552027910009219L;

    @JsonProperty("poster")
    private ImageURLs poster;
    @JsonProperty("fanart")
    private ImageURLs fanart;
    @JsonProperty("screenshot")
    private ImageURLs screenshot;
    @JsonProperty("headshot")
    private ImageURLs headshot;
    @JsonProperty("banner")
    private ImageURLs banner;
    @JsonProperty("logo")
    private ImageURLs logo;
    @JsonProperty("clearart")
    private ImageURLs clearart;
    @JsonProperty("thumb")
    private ImageURLs thumb;
    @JsonProperty("avatar")
    private ImageURLs avatar;

    public ImageURLs getPoster() {
        return poster;
    }

    public void setPoster(ImageURLs poster) {
        this.poster = poster;
    }

    public ImageURLs getFanart() {
        return fanart;
    }

    public void setFanart(ImageURLs fanart) {
        this.fanart = fanart;
    }

    public ImageURLs getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(ImageURLs screenshot) {
        this.screenshot = screenshot;
    }

    public ImageURLs getHeadshot() {
        return headshot;
    }

    public void setHeadshot(ImageURLs headshot) {
        this.headshot = headshot;
    }

    public ImageURLs getBanner() {
        return banner;
    }

    public void setBanner(ImageURLs banner) {
        this.banner = banner;
    }

    public ImageURLs getLogo() {
        return logo;
    }

    public void setLogo(ImageURLs logo) {
        this.logo = logo;
    }

    public ImageURLs getClearart() {
        return clearart;
    }

    public void setClearart(ImageURLs clearart) {
        this.clearart = clearart;
    }

    public ImageURLs getThumb() {
        return thumb;
    }

    public void setThumb(ImageURLs thumb) {
        this.thumb = thumb;
    }

    public ImageURLs getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageURLs avatar) {
        this.avatar = avatar;
    }
}
