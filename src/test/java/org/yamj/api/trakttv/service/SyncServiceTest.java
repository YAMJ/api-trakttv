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
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.trakttv.AbstractTests;
import org.yamj.api.trakttv.model.LastActivities;
import org.yamj.api.trakttv.model.TrackedMovie;
import org.yamj.api.trakttv.model.TrackedShow;
import org.yamj.api.trakttv.model.enumeration.Extended;

public class SyncServiceTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(SyncServiceTest.class);

    @Test
    public void empty() {
        // just an empty test to prevent failing build due missing tests
    }
    
    @Ignore
    public void testLastActivities() {
        LOG.info("testLastActivities");
        final LastActivities lastActivities = getTraktTvApi().syncService().getLastActivities();
        LOG.debug("{}", lastActivities);
    }

    @Ignore
    public void getCollectionMovies() {
        LOG.info("getCollectionMovies");
        final List<TrackedMovie> list = getTraktTvApi().syncService().getCollectionMovies(Extended.MINIMAL);
        for (TrackedMovie tracked : list) {
            LOG.debug("{}", tracked);
        }
    }

    @Ignore
    public void getCollectionShows() {
        LOG.info("getCollectionShows");
        final List<TrackedShow> list = getTraktTvApi().syncService().getCollectionShows(Extended.MINIMAL);
        for (TrackedShow tracked : list) {
            LOG.debug("{}", tracked);
        }
    }

    @Ignore
    public void getWatchedMovies() {
        LOG.info("getWatchedMovies");
        final List<TrackedMovie> list = getTraktTvApi().syncService().getWatchedMovies(Extended.MINIMAL);
        for (TrackedMovie tracked : list) {
            LOG.debug("{}", tracked);
        }
    }

    @Ignore
    public void getWatchedShows() {
        LOG.info("getWatchedShows");
        final List<TrackedShow> list = getTraktTvApi().syncService().getWatchedShows(Extended.MINIMAL);
        for (TrackedShow tracked : list) {
            LOG.debug("{}", tracked);
        }
    }
}
