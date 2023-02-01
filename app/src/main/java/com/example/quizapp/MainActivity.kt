package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        val name : EditText = findViewById(R.id.input_name)


        btnStart.setOnClickListener {

            if (name.text.isEmpty()) {
                Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
            } else {

                //Move screen
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.NAME, name.text.toString())
                startActivity(intent)
                finish() // will not able to go back to last screen/activity if finish()
            }


        }



    }




}