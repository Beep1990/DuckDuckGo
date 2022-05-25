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

package com.duckduckgo.app.launch

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.duckduckgo.app.browser.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LaunchBridgeActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(LaunchBridgeActivity::class.java)

    @Test
    fun launchBridgeActivityTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.primaryCta), withText("Let's Do It!"),
                childAtPosition(
                    allOf(
                        withId(R.id.daxCtaContainer),
                        childAtPosition(
                            withId(R.id.longDescriptionContainer),
                            2
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.primaryCta), withText("Let's Do It!"),
                childAtPosition(
                    allOf(
                        withId(R.id.daxCtaContainer),
                        childAtPosition(
                            withId(R.id.longDescriptionContainer),
                            2
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val keyboardAwareEditText = onView(
            allOf(
                withId(R.id.omnibarTextInput),
                childAtPosition(
                    allOf(
                        withId(R.id.omniBarContainer),
                        childAtPosition(
                            withId(R.id.toolbar),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        keyboardAwareEditText.perform(click())

        val frameLayout = onView(
            allOf(
                withId(R.id.browserMenu),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbarContainer),
                        childAtPosition(
                            withId(R.id.appBarLayout),
                            0
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        frameLayout.perform(click())

        val menuItemView = onView(
            allOf(
                withId(R.id.bookmarksMenuItem), withContentDescription("Bookmarks"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.menuScrollableContent),
                        0
                    ),
                    5
                )
            )
        )
        menuItemView.perform(scrollTo(), click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>,
        position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                    && view == parent.getChildAt(position)
            }
        }
    }
}
