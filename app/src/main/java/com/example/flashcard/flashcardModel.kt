package com.example.flashcard

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class flashcardModel: ViewModel()
{
    private val NUM:Int=10
    private var cardset:MutableList<Singleflashcard> = mutableListOf()

    private var currentIndex:Int=0
    init {
        for (i in 0 until NUM)
        {
            var op:Int=if (Random.nextInt() %2==0) 1 else -1
            cardset.add(Singleflashcard(op))
        }
    }

    fun getCurrentIndex():Int
    {
        return currentIndex
    }

    fun getOp1():Int
    {
        return cardset[currentIndex].getOp1()
    }

    fun getOp2():Int
    {
        return cardset[currentIndex].getOp2()
    }

    fun getOp():Int
    {
        return cardset[currentIndex].getOp()
    }

    fun isCorrect():Boolean
    {
        return cardset[currentIndex].isCorrect()
    }
    fun submitAnswer()
    {
        cardset[currentIndex].submitAnswer()
    }
    fun inputAnswer(a:String)
    {
        cardset[currentIndex].inputAnswer(a)
    }

    fun nextCard()
    {
        currentIndex++
        if (currentIndex>=NUM) currentIndex=NUM
    }

    fun getTotalScore():Int
    {
        var score:Int=0
        for (card in cardset)
        {
            if (card.isCorrect()) score++
        }
        return score
    }

}