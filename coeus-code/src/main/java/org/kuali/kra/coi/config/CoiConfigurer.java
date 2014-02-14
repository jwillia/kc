/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.coi.config;

import org.kuali.coeus.sys.framework.config.KcConfigurer;
import org.kuali.rice.core.api.config.module.RunMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoiConfigurer extends KcConfigurer {

    private static final String COI_SPRING_BEANS_PATH = "classpath:org/kuali/kra/coi/CoiSpringBeans.xml";

    public CoiConfigurer() {
        super("kc.coi", "KC COI");
        setValidRunModes(Arrays.asList(RunMode.LOCAL, RunMode.THIN));
    }

    @Override
    public List<String> getPrimarySpringFiles() {
        final List<String> springFileLocations = new ArrayList<String>();
        
        if (RunMode.LOCAL.equals(getRunMode())) {
            springFileLocations.add(COI_SPRING_BEANS_PATH);
        }
        
        return springFileLocations;
    }

}