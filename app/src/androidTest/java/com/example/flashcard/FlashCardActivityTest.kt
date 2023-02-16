package com.example.flashcard

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class FlashCardActivityTest {
    private lateinit var scenario: ActivityScenario<FlashCardActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(FlashCardActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testView() {
        onView(withId(R.id.question)).check(matches(withText("Question 1:")))

        for(i in 0..9) {
            onView(withId(R.id.answer)).perform(typeText("test"))
            onView(withId(R.id.answer)).perform(closeSoftKeyboard());
            onView(withId(R.id.submit)).perform(click())
        }

        onView(withId(R.id.answer)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun testLaunchActivity() {
        assertNotNull(scenario)
    }

}