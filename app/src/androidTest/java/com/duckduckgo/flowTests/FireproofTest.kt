/*
 * Copyright (c) 2022 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.flowTests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.duckduckgo.robots.FireproofingRobot
import com.duckduckgo.rules.ApplicationTestRule
import com.duckduckgo.rules.startActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FireproofTest {

    @get:Rule
    val applicationTestRule = ApplicationTestRule()

    @Before
    fun setUp() {
        startActivity()
    }

    @Test
    fun fireproofCase() {

        FireproofingRobot {
            tapLinkBar()
            enterWebLink()
            enableFireproof()
            fireproofCheck()
        }

    }

}
