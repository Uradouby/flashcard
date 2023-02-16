package com.example.flashcard

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import kotlin.random.Random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Before
    fun setUp(){

    }

    /**
     * login model test
     */
    @Test
    fun login_test() {
        // fake test case
        var fakeUser = "frank"
        var fakePassword = "pass1"

        var loginModel = LogInModel()
        loginModel.setUsername(fakeUser)
        loginModel.setPassword(fakePassword)

        assertEquals(loginModel.check(),  false)

        // success test case
        var user = "Wizard"
        var password = "Android501"

        loginModel.setUsername(user)
        loginModel.setPassword(password)

        assertEquals(loginModel.check(), true)
    }

    /**
     * single flash card test
     */
    @Test
    fun singleFlashTest() {
        var singleflashcard = Singleflashcard(1)
        // right answer
        singleflashcard.inputAnswer((singleflashcard.getOp1() + singleflashcard.getOp() * singleflashcard.getOp2()).toString())
        assertEquals(singleflashcard.isCorrect(), false)
        singleflashcard.submitAnswer()
        assertEquals(singleflashcard.isCorrect(), true)

        // false test case
        singleflashcard.inputAnswer((1..99).random().toString())
        singleflashcard.submitAnswer()
        assertEquals(singleflashcard.isCorrect(), false)
    }


    /**
     * test flashCard
     */
    @Test
    fun flashcardTest() {
        var flashcardmodel = flashcardModel()
        var right = 0
        var wrong = 0
        for (i in 0 until 10)
        {
            if (Random.nextInt() % 2 == 0) {
                inputRightAnswer(flashcardmodel)
                right++

            } else {
                inputWrongAnswer(flashcardmodel)
                wrong++
            }
            flashcardmodel.nextCard()
        }

        assertEquals(right, flashcardmodel.getTotalScore())
    }


    fun inputRightAnswer(flashcardmodel: flashcardModel) {
        flashcardmodel.inputAnswer((flashcardmodel.getOp1() + flashcardmodel.getOp() * flashcardmodel.getOp2()).toString())
        flashcardmodel.submitAnswer()
    }

    fun inputWrongAnswer(flashcardmodel: flashcardModel) {
        flashcardmodel.inputAnswer((1..99).random().toString())
        flashcardmodel.submitAnswer()
    }
}