package com.example.flashcard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import com.example.flashcard.databinding.ActivityFlashCardBinding
import com.example.flashcard.databinding.ActivityGenerateBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class FlashCardActivity : AppCompatActivity() {
    companion object {
        fun newIntent(packageContext: Context): Intent {
            return Intent(packageContext, FlashCardActivity::class.java)
        }
    }

    private lateinit var binding:ActivityFlashCardBinding
    private val model:flashcardModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFlashCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
        updateScene()
    }

    fun setListener()
    {
        binding.quit.setOnClickListener{
            this.finish()
        }

        binding.submit.setOnClickListener{
            model.submitAnswer()
            if (model.getCurrentIndex()==9)
            {
                Snackbar.make(binding.root,"Your Score is: "+model.getTotalScore().toString(),
                    BaseTransientBottomBar.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    this.finish()
                }, 2000)
            }
            else
            {
                Snackbar.make(binding.root,model.isCorrect().toString(),
                   1000).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    model.nextCard()
                    binding.answer.setText("")
                    updateScene()
                }, 1000)
            }
        }

        binding.answer.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }
             override fun afterTextChanged(editable: Editable) {
                model.inputAnswer(editable.toString())
             }
        })
    }

    @SuppressLint("SetTextI18n")
    fun updateScene()
    {
        binding.question.text="Question "+(model.getCurrentIndex()+1).toString()+":"
        binding.op.text = if (model.getOp()==1) "+" else "-"
        binding.op1.text = model.getOp1().toString()
        binding.op2.text = model.getOp2().toString()
    }
}