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

package com.duckduckgo.robots

inline fun ChangeAppIconRobot(block: ChangeAppIconRobot.() -> Unit) = ChangeAppIconRobot.block()

object ChangeAppIconRobot {

    fun tapMenuButton() {
        tapOnButton(R.id.browserMenu)
    }

    fun tapSettingsButton() {
        tapOnButton(R.id.settingsMenuItem)
    }

    fun tapAppIconButton() {
        tapOnButton(R.id.changeAppIconLabel)
    }

    fun newIconTap() {
    }

    fun applyNewIcon() {
        waitUntilViewIsDisplayed(withId(android.R.id.button1))
        tapOnButtonWithText(android.R.id.button1, R.string.changeIconCtaAccept)
    }

    /*fun iconCheck() {
        newIconCheck(R.id.menuScrollableContent, R.id.settingsMenuItem)
    }*/
}
