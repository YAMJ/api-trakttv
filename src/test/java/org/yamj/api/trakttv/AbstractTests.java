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
package org.yamj.api.trakttv;

import java.io.File;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTests.class);
    private static final String PROP_FILENAME = "testing.properties";
    private final Properties props = new Properties();
    private TraktTvApi traktTvApi;
    private static final String ACCESS_TOKEN = "Access_Token";
    private static final String CLIENT_SECRET = "Client_Secret";
    private static final String CLIENT_ID = "Client_ID";

    protected TraktTvApi getTraktTvApi() {
        if (traktTvApi != null) {
            return traktTvApi;
        }

        TestLogger.configure();

        if (props.isEmpty()) {
            File f = new File(PROP_FILENAME);
            if (f.exists()) {
                LOG.info("Loading properties from '{}'", PROP_FILENAME);
                TestLogger.loadProperties(props, f);
            } else {
                LOG.info("Property file '{}' not found, creating dummy file.", PROP_FILENAME);

                props.setProperty(CLIENT_ID, "INSERT_YOUR_CLIENT_ID_HERE");
                props.setProperty(CLIENT_SECRET, "INSERT_YOUR_CLIENT_SECRET_HERE");
                props.setProperty(ACCESS_TOKEN, "INSERT_VALID_ACCESS_TOKEN_HERE");

                TestLogger.saveProperties(props, f, "Properties file for tests");
                Assert.fail("Failed to get key information from properties file '" + PROP_FILENAME + "'");
            }
        }

        traktTvApi = new TraktTvApi(props.getProperty(CLIENT_ID), props.getProperty(CLIENT_SECRET));
        if (StringUtils.isNotBlank(props.getProperty(ACCESS_TOKEN))) {
            traktTvApi.setAccessToken(props.getProperty(ACCESS_TOKEN));
        }
        return traktTvApi;
    }
}
