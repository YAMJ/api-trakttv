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
package org.yamj.api.trakttv.service;

import org.yamj.api.trakttv.AbstractTests;

import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.trakttv.model.Episode;
import org.yamj.api.trakttv.model.Ratings;
import org.yamj.api.trakttv.model.Season;
import org.yamj.api.trakttv.model.enumeration.Extended;

public class SeasonServiceTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(SeasonServiceTest.class);
    private static final String ID_THEFLASH = "the-flash-2014";

    @BeforeClass
    public static void setUpClass() {
        doConfiguration();
    }

    @Test
    public void testGetSeasons() {
        LOG.info("testGetSeasons");
        final List<Season> seasons = getTraktTvApi().seasonService().getSeasons(ID_THEFLASH);
        Assert.assertTrue(seasons.size() > 1);
        LOG.debug("{}", seasons);
    }

    @Test
    public void testGetRatings() {
        LOG.info("testGetRatings");
        final Ratings ratings = getTraktTvApi().seasonService().getRatings(ID_THEFLASH, 1);
        Assert.assertTrue(ratings.getRating() > 7.0d);
        LOG.debug("{}", ratings);
    }

    @Test
    public void testGetEpisodes() {
        LOG.info("testGetEpisodes");
        final List<Episode> episodes = getTraktTvApi().seasonService().getEpisodes(ID_THEFLASH, 1, Extended.FULLIMAGES);
        Assert.assertEquals(23, episodes.size());
        LOG.debug("{}", episodes);
    }
}
