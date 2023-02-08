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

package com.duckduckgo.actions


import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers

/*fun newIconCheck(@IdRes viewId: Int, position: Int) {
    onView(allOf(withId(viewId), withId(position)))
        .check(ViewAssertions.matches(ViewMatchers.isSelected()))
}*/

fun fireproofCheckAssertion(@IdRes viewId: Int, stringId: String ) {
    onView(allOf(withId(viewId), withText(stringId)))
        .check(matches(withText(stringId)))
}

fun assertTextIsDisplayed(@IdRes viewId: Int, @StringRes StringId: String) {
    onView(Matchers.allOf(withId(viewId), withText(StringId)))
        .check(matches(ViewMatchers.isDisplayed()))
}
