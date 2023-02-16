package com.example.flashcard

import org.junit.Assert
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class flashcardModelTest {
    /**
     * single flash card test
     */
    @org.junit.Test
    fun singleFlashTest() {
        var singleflashcard = Singleflashcard(1)
        // right answer
        singleflashcard.inputAnswer((singleflashcard.getOp1() + singleflashcard.getOp() * singleflashcard.getOp2()).toString())
        Assert.assertEquals(singleflashcard.isCorrect(), false)
        singleflashcard.submitAnswer()
        Assert.assertEquals(singleflashcard.isCorrect(), true)

        // false test case
        singleflashcard.inputAnswer((1..99).random().toString())
        singleflashcard.submitAnswer()
        Assert.assertEquals(singleflashcard.isCorrect(), false)
    }


    /**
     * test flashCard
     */
    @org.junit.Test
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

        Assert.assertEquals(right, flashcardmodel.getTotalScore())
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