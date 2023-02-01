package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        val name : TextView = findViewById(R.id.name)
        val score : TextView = findViewById(R.id.score)
        val button : Button = findViewById(R.id.finish_btn)

        name.text = intent.getStringExtra(Constants.NAME)
        score.text = "Your Score is ${intent.getIntExtra(Constants.SCORE, 0)} out of 10"

        button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}