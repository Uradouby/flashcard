package com.example.flashcard

import androidx.lifecycle.ViewModel

class checkModel:ViewModel() {
    private var login:Boolean=false

    fun logout()
    {
        login=false
    }

    fun login()
    {
        login=true
    }

    fun islogin():Boolean
    {
        return login
    }
}