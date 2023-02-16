package com.example.flashcard

import org.junit.Assert
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class LogInModelTest {

    @org.junit.Test
    fun check() {
        // fake test case
        var fakeUser = "frank"
        var fakePassword = "pass1"

        var loginModel = LogInModel()
        loginModel.setUsername(fakeUser)
        loginModel.setPassword(fakePassword)

        Assert.assertEquals(loginModel.check(), false)

        // success test case
        var user = "Wizard"
        var password = "Android501"

        loginModel.setUsername(user)
        loginModel.setPassword(password)

        Assert.assertEquals(loginModel.check(), true)
    }


}