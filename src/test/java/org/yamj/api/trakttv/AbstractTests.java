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

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.trakttv.TraktTvApi;

public class AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTests.class);
    private static final String PROP_FIlENAME = "testing.properties";
    private final Properties props = new Properties();
    private TraktTvApi traktTvApi;
    
    protected TraktTvApi getTraktTvApi() {
        if (traktTvApi != null) {
            return traktTvApi;
        }

        TestLogger.configure();
    
        if (props.isEmpty()) {
            File f = new File(PROP_FIlENAME);
            if (f.exists()) {
                LOG.info("Loading properties from '{}'", PROP_FIlENAME);
                TestLogger.loadProperties(props, f);
            } else {
                LOG.info("Property file '{}' not found, creating dummy file.", PROP_FIlENAME);

                props.setProperty("Client_ID", "INSERT_YOUR_CLIENT_ID_HERE");
                props.setProperty("Client_Secret", "INSERT_YOUR_CLIENT_SECRET_HERE");
                props.setProperty("Username", "INSERT_YOUR_USERNAME_HERE");
                props.setProperty("Password", "INSERT_YOUR_PASSWORD_HERE");

                TestLogger.saveProperties(props, f, "Properties file for tests");
                fail("Failed to get key information from properties file '" + PROP_FIlENAME + "'");
            }
        }

        traktTvApi = new TraktTvApi(props.getProperty("Client_ID"));
        return traktTvApi;
    }
}
