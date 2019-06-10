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
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.trakttv.AbstractTests;
import org.yamj.api.trakttv.model.Movie;
import org.yamj.api.trakttv.model.SearchResult;
import org.yamj.api.trakttv.model.enumeration.IdType;

public class SearchServiceTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(SearchServiceTest.class);

    @BeforeClass
    public static void setUpClass() {
        doConfiguration();
    }

    @Test
    public void searchMovieByTraktId() {
        LOG.info("searchMovieByIMDB");
        List<SearchResult> searchResults = getTraktTvApi().searchService().idSearch(IdType.TRAKT_MOVIE, "128378");
        Assert.assertEquals(1, searchResults.size());
        Movie movie = searchResults.get(0).getMovie();
        Assert.assertNotNull(movie);
        Assert.assertEquals(Integer.valueOf(128378), movie.getIds().trakt());
    }

    @Test
    public void searchMovieByIMDB() {
        LOG.info("searchMovieByIMDB");
        List<SearchResult> searchResults = getTraktTvApi().searchService().idSearch(IdType.IMDB, "tt2379713");
        Assert.assertEquals(1, searchResults.size());
        Movie movie = searchResults.get(0).getMovie();
        Assert.assertNotNull(movie);
        Assert.assertEquals(Integer.valueOf(128378), movie.getIds().trakt());
    }

    @Test
    public void searchMovieByTMDB() {
        LOG.info("searchMovieByTMDB");
        List<SearchResult> searchResults = getTraktTvApi().searchService().idSearch(IdType.TMDB, "206647");
        Assert.assertEquals(3, searchResults.size());
        Movie movie = null;
        for (SearchResult searchResult : searchResults) {
            if (searchResult.getMovie() != null) {
                movie = searchResult.getMovie();
                break;
            }
        }
        Assert.assertNotNull(movie);
        Assert.assertEquals(Integer.valueOf(128378), movie.getIds().trakt());
    }
}
