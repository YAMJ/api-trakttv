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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.trakttv.model.*;
import org.yamj.api.trakttv.model.enumeration.Extended;

public class MovieServiceTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(MovieServiceTest.class);
    private static final String ID_TRANSFORMERS = "transformers-2007";
    private static final String ID_AVATAR = "avatar-2009";
    private static final String LANG_DE = "DE";

    @BeforeClass
    public static void setUpClass() {
        doConfiguration();
    }

    @Test
    public void testGetMovie() {
        LOG.info("testGetMovie");
        final Movie movie = getTraktTvApi().movieService().getMovie(ID_TRANSFORMERS, Extended.FULLIMAGES);
        assertEquals("tt0418279", movie.getIds().imdb());
        LOG.debug("{}", movie);
    }

    @Test
    public void testGetAliases() {
        LOG.info("testGetAliases");
        final List<Alias> aliases = getTraktTvApi().movieService().getAliases(ID_AVATAR);
        assertTrue(aliases.size() > 5);
        LOG.debug("{}", aliases);
    }

    @Test
    public void testGetTranslations() {
        LOG.info("testGetTranslations");
        final List<Translation> translations = getTraktTvApi().movieService().getTranslations(ID_TRANSFORMERS);
        assertTrue(translations.size() > 2);
        LOG.debug("{}", translations);
    }

    @Test
    public void testGetTranslation() {
        LOG.info("testGetTranslation");
        final List<Translation> translations = getTraktTvApi().movieService().getTranslation(ID_TRANSFORMERS, LANG_DE);
        assertTrue(translations.isEmpty());
        LOG.debug("{}", translations);
    }

    @Test
    public void testGetReleases() {
        LOG.info("testGetReleases");
        final List<Release> releases = getTraktTvApi().movieService().getReleases(ID_AVATAR, LANG_DE);
        assertEquals(0, releases.size());
        LOG.debug("{}", releases);
    }

    @Test
    public void testGetRatings() {
        LOG.info("testGetRatings");
        final Ratings ratings = getTraktTvApi().movieService().getRatings(ID_TRANSFORMERS);
        assertTrue(ratings.getRating() > 7.0d);
        LOG.debug("{}", ratings);
    }

    @Test
    public void testGetCredits() {
        LOG.info("testGetCredits");
        final Credits credits = getTraktTvApi().movieService().getCredits(ID_TRANSFORMERS);
        assertTrue(credits.getCast().size() > 10);
        assertTrue(credits.getCrew().getDirecting().size() > 0);
        LOG.debug("{}", credits);
    }
}
