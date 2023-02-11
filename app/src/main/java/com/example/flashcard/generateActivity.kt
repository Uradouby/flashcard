package com.example.flashcard

import android.view.View
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.flashcard.databinding.ActivityGenerateBinding
import com.example.flashcard.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

private var USERNAME =
    "com.example.falshcard.username"

class generateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenerateBinding
    private val model:checkModel by viewModels()

    companion object {
        fun newIntent(packageContext: Context, username: String): Intent {
            return Intent(packageContext, generateActivity::class.java).apply {
                putExtra(USERNAME, username)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenerateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (!model.islogin())
        {
            welcome()
            model.login()
        }
        setListener()
    }

    fun welcome()
    {
        Snackbar.make(
            binding.root,
            "Welcome "+intent.getStringExtra(USERNAME)+"!",
            BaseTransientBottomBar.LENGTH_SHORT).show()
    }

    fun setListener()
    {
        binding.generate.setOnClickListener{
            intent=FlashCardActivity.newIntent(this@generateActivity)
            startActivity(intent)
        }

        binding.logout.setOnClickListener{
            model.logout()
            this.finish()
        }
    }

}