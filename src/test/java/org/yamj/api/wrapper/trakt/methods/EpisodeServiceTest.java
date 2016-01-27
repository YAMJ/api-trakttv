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
package org.yamj.api.wrapper.trakt.methods;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.trakttv.model.Episode;
import org.yamj.api.trakttv.model.Ratings;
import org.yamj.api.trakttv.model.enumeration.Extended;
import org.yamj.api.wrapper.trakt.AbstractTests;

public class EpisodeServiceTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(EpisodeServiceTest.class);

    @Test
    public void testGetEpisode() {
        LOG.info("testGetEpisode");
        final Episode episode = getTraktTvApi().episodeService().getEpisode("the-flash-2014", 1, 5, Extended.FULLIMAGES);
        Assert.assertEquals(Integer.valueOf(999423), episode.getIds().trakt());
        LOG.debug("{}", episode);
    }

    @Test
    public void testGetRatings() {
        LOG.info("testGetRatings");
        final Ratings ratings =  getTraktTvApi().episodeService().getRatings("the-flash-2014", 1, 5);
        Assert.assertTrue(ratings.getRating() > 7.0d);
        LOG.debug("{}", ratings);
    }
}
