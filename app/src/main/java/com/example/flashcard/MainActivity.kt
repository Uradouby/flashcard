package com.example.flashcard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.flashcard.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: LogInModel by viewModels()

    companion object {
        fun newIntent(packageContext: Context): Intent {
            return Intent(packageContext, MainActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setListener()
        setContentView(binding.root)
        updateScene()
    }

    fun updateScene()
    {
        //Log.d("update", "model show"+model.show())
        binding.username.setText(model.getUsername())
        binding.password.setText(model.getPassword())
    }

    fun setListener()
    {
        binding.username.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(editable: Editable) {
                model.setUsername(editable.toString())
            }
        })

        binding.password.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(editable: Editable) {
                model.setPassword(editable.toString())
            }
        })

        binding.login.setOnClickListener{view: View ->
            if (model.check())
            {
                val intent = generateActivity.newIntent(this@MainActivity, model.getUsername())
                startActivity(intent)
            }
            else
            {
                Snackbar.make(
                    this,
                    view,
                    "Wrong username or password :(",
                    BaseTransientBottomBar.LENGTH_SHORT).show()
            }
        }
    }

}