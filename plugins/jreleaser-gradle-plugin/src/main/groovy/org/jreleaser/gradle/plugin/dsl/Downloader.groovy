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
package org.jreleaser.gradle.plugin.dsl

import groovy.transform.CompileStatic
import org.gradle.api.Action
import org.gradle.api.provider.Property

/**
 *
 * @author Andres Almiray
 * @since 1.1.0
 */
@CompileStatic
interface Downloader extends Activatable, ExtraProperties {
    Property<Integer> getConnectTimeout()

    Property<Integer> getReadTimeout()

    Unpack getUnpack()

    void unpack(Action<? super Unpack> action)

    void unpack(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = Unpack) Closure<Void> action)

    interface Unpack {
        Property<Boolean> getEnabled()

        Property<Boolean> getSkipRootEntry()
    }
}