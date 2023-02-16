package com.example.flashcard

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel

class LogInModel: ViewModel()  {
    private var username:String=""
    private var password:String=""
    fun getUsername():String
    {
        return username
    }

    fun getPassword():String
    {
        return password

    }

    fun setUsername(u:String)
    {
        Log.d("aa","setuser")
        username=u
    }

    fun setPassword(p:String)
    {
        password=p
    }

    fun check():Boolean
    {
//      return true
        //if (username!= Resources.getSystem().getString(R.string.username)) return false
        //if (password!=Resources.getSystem().getString(R.string.password)) return false
        if (username!="Wizard") return false
        if (password!="Android501") return false
        return true
    }
}