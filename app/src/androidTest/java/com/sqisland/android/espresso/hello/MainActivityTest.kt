package com.sqisland.android.espresso.hello

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    //Rule means that the main activity will be called every time a test is called
    //JvmField is a Kotlin fix, it is need to make the test work
    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
            MainActivity::class.java
    )

    @Test
    fun greet() {
        onView(withId(R.id.greeting))
                .check(matches(withText("")));
    }

    @Test
    fun greetAfterClick() {
        onView(withId(R.id.greet_button))
                .perform(click());

        onView(withId(R.id.greeting))
                .check(matches(withText(R.string.hello)));

        onView(withId(R.id.greet_button))
                .check(matches(not(isEnabled())))
    }
}