/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2022 The JReleaser authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jreleaser.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Andres Almiray
 * @since 1.1.0
 */
public interface Downloader extends Domain, Activatable, TimeoutAware, ExtraProperties {
    String getType();

    String getName();

    void setName(String name);

    Unpack getUnpack();

    void setUnpack(Unpack unpack);

    class Unpack implements Domain, EnabledAware {
        private Boolean enabled;
        private Boolean skipRootEntry;

        void setAll(Unpack unpack) {
            this.enabled = unpack.enabled;
            this.skipRootEntry = unpack.skipRootEntry;
        }

        @Override
        public boolean isEnabled() {
            return enabled != null && enabled;
        }

        @Override
        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        @Override
        public boolean isEnabledSet() {
            return enabled != null;
        }

        public boolean isSkipRootEntry() {
            return skipRootEntry != null && skipRootEntry;
        }

        public void setSkipRootEntry(Boolean skipRootEntry) {
            this.skipRootEntry = skipRootEntry;
        }

        public boolean isSkipRootEntrySet() {
            return skipRootEntry != null;
        }

        @Override
        public Map<String, Object> asMap(boolean full) {
            if (!full && !isEnabled()) return Collections.emptyMap();

            Map<String, Object> props = new LinkedHashMap<>();
            props.put("enabled", isEnabled());
            props.put("skipRootEntry", isSkipRootEntry());

            return props;
        }
    }
}
