/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.accessservices.governanceprogram.fvt.execution;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.odpi.openmetadata.accessservices.governanceprogram.samples.leadership.GovernanceLeadershipSample;
import org.odpi.openmetadata.accessservices.governanceprogram.samples.subjectareas.CreateSubjectAreasSample;
import org.odpi.openmetadata.fvt.utilities.FVTConstants;
import org.odpi.openmetadata.http.HttpHelper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * GovernanceProgramOMASSubjectAreaIT is the failsafe wrapper for running the governance subject area sample as an FVT.
 */
public class GovernanceProgramOMASSubjectAreaIT
{
    @BeforeAll
    public static void disableStrictSSL(){
        HttpHelper.noStrictSSL();
    }

    @ParameterizedTest
    @ValueSource(strings = {"serverinmem","servergraph"})
    public void testGovernanceLeadership(String server)
    {
        assertDoesNotThrow(() -> runGovernanceLeadership(server));
    }


    public void runGovernanceLeadership(String serverName)
    {
        CreateSubjectAreasSample sample = new CreateSubjectAreasSample(serverName,
                                                                       StringUtils.defaultIfEmpty(System.getProperty("fvt.url"),FVTConstants.SERVER_PLATFORM_URL_ROOT),
                                                                       FVTConstants.USERID);

        sample.run();
    }
}
