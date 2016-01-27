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

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.trakttv.AbstractTests;
import org.yamj.api.trakttv.model.*;
import org.yamj.api.trakttv.model.enumeration.Extended;

public class ShowServiceTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(ShowServiceTest.class);

    @Test
    public void testGetShow() {
        LOG.info("testGetShow");
        final Show show = getTraktTvApi().showService().getShow("the-flash-2014", Extended.FULLIMAGES);
        Assert.assertEquals(Integer.valueOf(279121), show.getIds().tvdb());
        LOG.debug("{}", show);
    }

    @Test
    public void testGetAliases() {
        LOG.info("testGetAliases");
        final List<Alias> aliases = getTraktTvApi().showService().getAliases("the-flash-2014");
        Assert.assertTrue(aliases.size() > 5);
        LOG.debug("{}", aliases);
    }

    @Test
    public void testGetTranslations() {
        LOG.info("testGetTranslations");
        final List<Translation>  translations = getTraktTvApi().showService().getTranslations("the-flash-2014");
        Assert.assertTrue(translations.size() > 2);
        LOG.debug("{}", translations);
    }

    @Test
    public void testGetTranslation() {
        LOG.info("testGetTranslation");
        final List<Translation>  translations = getTraktTvApi().showService().getTranslation("the-flash-2014", "de");
        Assert.assertTrue(translations.size() > 0);
        LOG.debug("{}", translations);
    }

    @Test
    public void testGetRatings() {
        LOG.info("testGetRatings");
        final Ratings ratings =  getTraktTvApi().showService().getRatings("the-flash-2014");
        Assert.assertTrue(ratings.getRating() > 7.0d);
        LOG.debug("{}", ratings);
    }

    @Test
    public void testGetCredits() {
        LOG.info("testGetCredits");
        final Credits credits =  getTraktTvApi().showService().getCredits("the-flash-2014");
        Assert.assertTrue(credits.getCast().size() > 5);
        LOG.debug("{}", credits);
    }
}
