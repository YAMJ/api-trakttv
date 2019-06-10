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
package org.yamj.api.trakttv.model.enumeration;

public enum Extended {

    // none (default)
    NONE("none"),
    // minimal info
    MINIMAL("min"),
    // minimal info and images
    IMAGES("images"),
    // complete info
    FULL("full"),
    // complete info and all images
    FULLIMAGES("full,images"),
    // metadata from movie file
    METADATA("metadata");

    private final String value;

    private Extended(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
