package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var gCurrentProgress : Int = 1
    private var gQuestionsList : ArrayList<Question>? = null
    private var gSelectedOptionPosition : Int? = null
    private var gSelectedAnswer : Boolean = false

    private var gName : String? = null
    private var gScore : Int = 0

    private var question : TextView? = null
    private var image : ImageView? = null
    private var progressBar : ProgressBar? = null
    private var progressText : TextView? = null
    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null

    private var submitBtn : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        gName = intent.getStringExtra(Constants.NAME)


        question = findViewById(R.id.question)
        image = findViewById(R.id.flag_image)
        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.progress_bar_text)
        optionOne = findViewById(R.id.option_one)
        optionTwo = findViewById(R.id.option_two)
        optionThree = findViewById(R.id.option_three)
        optionFour = findViewById(R.id.option_four)

        submitBtn = findViewById(R.id.submit_btn)


        gQuestionsList = Constants.getQuestions()


        setQuestion()



    }

    private fun setQuestion() {

        defaultOptionStyle()

        val currentQuestion: Question = gQuestionsList!![gCurrentProgress - 1]

        progressBar?.progress = gCurrentProgress
        progressText?.text = "$gCurrentProgress/${progressBar?.max}"

        question?.text = currentQuestion.question
        image?.setImageResource(currentQuestion.image)

        optionOne?.text = currentQuestion.optionOne
        optionTwo?.text = currentQuestion.optionTwo
        optionThree?.text = currentQuestion.optionThree
        optionFour?.text = currentQuestion.optionFour

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        submitBtn?.setOnClickListener(this)


        if (gCurrentProgress <= gQuestionsList!!.size) {
            submitBtn?.text = "SUBMIT ANSWER"
        }

    }

    private fun defaultOptionStyle() {

        val options = arrayListOf<TextView>()

        options.add(optionOne!!)
        options.add(optionTwo!!)
        options.add(optionThree!!)
        options.add(optionFour!!)

        for (optionTextView in options) {
            optionTextView.setTextColor(Color.GRAY)
            optionTextView.typeface = Typeface.DEFAULT
            optionTextView.background = ContextCompat.getDrawable(this, R.drawable.options_border_bg)
        }

    }

    private fun selectedOptionStyle(selectedTextView: TextView, selectedOption: Int) {

        defaultOptionStyle()

        gSelectedAnswer = true
        gSelectedOptionPosition = selectedOption

        selectedTextView.setTextColor(Color.DKGRAY)
        selectedTextView.setTypeface(selectedTextView.typeface, Typeface.BOLD)
        selectedTextView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }




    override fun onClick(view: View?) {

        when(view?.id) {

            R.id.option_one -> selectedOptionStyle(optionOne!!, 1)
            R.id.option_two -> selectedOptionStyle(optionTwo!!, 2)
            R.id.option_three -> selectedOptionStyle(optionThree!!, 3)
            R.id.option_four -> selectedOptionStyle(optionFour!!, 4)

            R.id.submit_btn -> {

                if (gSelectedAnswer){

                    //This code will get new a new question.
                    if (gSelectedOptionPosition == 0) {

                        gCurrentProgress++

                        when {
                            gCurrentProgress <= gQuestionsList!!.size -> {
                                setQuestion()
                                gSelectedAnswer = false
                            }
                            else -> {
                                val intent = Intent(this, ResultActivity::class.java)
                                intent.putExtra(Constants.NAME, gName)
                                intent.putExtra(Constants.SCORE, gScore)
                                startActivity(intent)
                                finish()
                            }
                        }


                        gSelectedAnswer = false

                    // This code will check the answer if it corrects or wrong.
                    } else {
                        val question = gQuestionsList?.get(gCurrentProgress - 1)

                        if(question!!.answer != gSelectedOptionPosition) {
                            answerBgStyle(gSelectedOptionPosition!!, R.drawable.incorrect_answer_bg)
                        } else {
                            gScore++
                        }

                        // Correct answer will always have green border.
                        answerBgStyle(question.answer, R.drawable.correct_answer_bg)

                        if (gCurrentProgress == gQuestionsList!!.size) {
                            submitBtn?.text = "FINISH"
                        } else {
                            submitBtn?.text = "NEXT"
                        }

                        gSelectedOptionPosition = 0

                    }

                } else {
                    Toast.makeText(this, "Select your answer.", Toast.LENGTH_SHORT).show()
                }


            }

        }

    }


    private fun answerBgStyle(answer: Int, drawable: Int) {

        when(answer){

            1 -> optionOne?.background = ContextCompat.getDrawable(this, drawable)
            2 -> optionTwo?.background = ContextCompat.getDrawable(this, drawable)
            3 -> optionThree?.background = ContextCompat.getDrawable(this, drawable)
            4 -> optionFour?.background = ContextCompat.getDrawable(this, drawable)

        }


    }



}
