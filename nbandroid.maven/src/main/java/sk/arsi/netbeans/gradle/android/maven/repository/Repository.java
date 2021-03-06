/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package sk.arsi.netbeans.gradle.android.maven.repository;

import java.util.Objects;

/**
 *
 * @author arsi
 */
public abstract class Repository {

    protected final String url;
    protected final RepositoryType type;

    public Repository(String url, RepositoryType type) {
        this.url = url;
        this.type = type;
    }

    public RepositoryType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }

    public String extractNameFromUrl() {
        String repoName = url.replace("https://", "");
        repoName = repoName.replace("http://", "");
        repoName = repoName.replace("/", "_");
        repoName = repoName.replace(".", "_");
        return repoName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.url);
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
        final Repository other = (Repository) obj;
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }

}
