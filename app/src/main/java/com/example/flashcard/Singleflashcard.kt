package com.example.flashcard

import kotlinx.coroutines.supervisorScope
import kotlin.random.Random

class Singleflashcard constructor(type:Int)
{
    private var op1:Int = (1..99).random()
    private var op2:Int = (1..20).random()
    private var op:Int=if (type>0) 1 else -1
    private var answer:Int=op1+op*op2
    private var inputAnswer:String=""
    private var answered:Boolean=false


    fun getOp1():Int
    {
        return op1
    }

    fun getOp2():Int
    {
        return op2
    }

    fun getOp():Int
    {
        return op
    }

    fun getAnswer():Int
    {
        return answer
    }

    fun inputAnswer(a:String)
    {
        inputAnswer=a
    }

    fun submitAnswer()
    {
        answered=true
    }

    fun isCorrect():Boolean
    {
        if (!answered) return false
        return inputAnswer==answer.toString()
    }
}