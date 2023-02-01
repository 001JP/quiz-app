package com.example.quizapp

import kotlin.collections.ArrayList

lateinit var options: ArrayList<String>

object Constants {

    const val NAME: String = "name"
    const val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question>{

        var options = countriesOption("Belgium").shuffled()
        val que1 = Question(
            1, "What flag is this?",
            R.drawable.ic_flag_of_belgium,
            options[0], options[1], options[2], options[3],
            options.indexOf("Belgium") + 1
        )

        options = countriesOption("Kuwait").shuffled()
        val que2 = Question(
            2, "What flag is this?",
            R.drawable.ic_flag_of_kuwait,
            options[0], options[1], options[2], options[3],
            options.indexOf("Kuwait") + 1
        )

        options = countriesOption("Argentina").shuffled()
        val que3 = Question(
            3, "What flag is this?",
            R.drawable.ic_flag_of_argentina,
            options[0], options[1], options[2], options[3],
            options.indexOf("Argentina") + 1
        )

        options = countriesOption("New Zealand").shuffled()
        val que4 = Question(
            4, "What flag is this?",
            R.drawable.ic_flag_of_new_zealand,
            options[0], options[1], options[2], options[3],
            options.indexOf("New Zealand") + 1
        )

        options = countriesOption("Fiji").shuffled()
        val que5 = Question(
            5, "What flag is this?",
            R.drawable.ic_flag_of_fiji,
            options[0], options[1], options[2], options[3],
            options.indexOf("Fiji") + 1
        )

        options = countriesOption("Germany").shuffled()
        val que6 = Question(
            6, "What flag is this?",
            R.drawable.ic_flag_of_germany,
            options[0], options[1], options[2], options[3],
            options.indexOf("Germany") + 1
        )

        options = countriesOption("India").shuffled()
        val que7 = Question(
            7, "What flag is this?",
            R.drawable.ic_flag_of_india,
            options[0], options[1], options[2], options[3],
            options.indexOf("India") + 1
        )

        options = countriesOption("Brazil").shuffled()
        val que8 = Question(
            8, "What flag is this?",
            R.drawable.ic_flag_of_brazil,
            options[0], options[1], options[2], options[3],
            options.indexOf("Brazil") + 1
        )

        options = countriesOption("Denmark").shuffled()
        val que9 = Question(
            9, "What flag is this?",
            R.drawable.ic_flag_of_denmark,
            options[0], options[1], options[2], options[3],
            options.indexOf("Denmark") + 1
        )

        options = countriesOption("Australia").shuffled()
        val que10 = Question(
            10, "What flag is this?",
            R.drawable.ic_flag_of_australia,
            options[0], options[1], options[2], options[3],
            options.indexOf("Australia") + 1
        )

        val questionsList = ArrayList<Question>()

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)

        questionsList.shuffle()

        return questionsList

    }

    private fun countriesOption(answer: String): Set<String>{

        val options = mutableSetOf<String>()
        options.add(answer)
        val countries = arrayListOf(
            "Argentina",
            "Australia",
            "Belgium",
            "Brazil",
            "Denmark",
            "Fiji",
            "Germany",
            "India",
            "Kuwait",
            "New Zealand"
        )

        do {

            options.add(countries[(0..9).random()])

        } while (options.size < 4)

        return options

    }

}




