/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.android.project.api;

import java.util.Objects;
import org.gradle.internal.impldep.org.apache.commons.lang.StringEscapeUtils;
import org.netbeans.spi.project.ProjectConfiguration;

/**
 *
 * @author arsi
 */
public class NbAndroidProjectConfiguration implements ProjectConfiguration {

    private String displayName;
    private final NbAndroidProjectConfigurationProvider provider;
    public static final String DEFAULT_TEXT = "<default config>";

    public NbAndroidProjectConfiguration(String displayName, NbAndroidProjectConfigurationProvider provider) {
        this.displayName = displayName;
        this.provider = provider;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
    
     public boolean isDefault(){
        return DEFAULT_TEXT.equals(displayName);
    }
    
    public String getHtmlDisplayName() {
        if (!provider.getActiveConfiguration().equals(this)) {
            return "<html>"+StringEscapeUtils.escapeXml(displayName)+"</html>";
        }else{
            return "<html><b>"+StringEscapeUtils.escapeXml(displayName)+"</b></html>";
        }
    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.displayName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NbAndroidProjectConfiguration other = (NbAndroidProjectConfiguration) obj;
        if (!Objects.equals(this.displayName, other.displayName)) {
            return false;
        }
        return true;
    }

}
