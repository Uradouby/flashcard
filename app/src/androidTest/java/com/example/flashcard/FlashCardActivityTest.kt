package com.example.flashcard

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

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
    fun testLaunchActivity() {
        assertNotNull(scenario)
    }

    @Test
    fun testView() {
//        onView(withId(R.id.question)).check(matches(withText("Question 1:")))
        onView(withId(R.id.answer)).perform(typeText("10"))
        onView(withId(R.id.submit)).perform(click())
    }

}