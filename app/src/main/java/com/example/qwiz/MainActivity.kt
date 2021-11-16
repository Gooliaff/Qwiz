package com.example.qwiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var questions = listOf(
        "What are the two official languages for Android development? \n\n A) Kotlin and Java \n\n B) Java and Python \n\n C) Kotlin and Python",
        "How do you define a function in Kotlin? \n\n A) void \n\n B) var \n\n C) function",
        "What is a variable used for? \n\n A) To contain data \n\n B) To insert a random value \n\n C) Don't know",
        "What does SDK stand for in Android SDK? \n\n A) Software Development Kit \n\n B) Software Development Kotlin \n\n C) Something Don't Know"
    )


    var rightAnswers = listOf(1, 2, 1, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button_One: Button = findViewById(R.id.button1)
        val button_Two: Button = findViewById(R.id.button2)
        val button_Tree: Button = findViewById(R.id.button3)



        button_One.setOnClickListener {
            showToast(1)
        }

        button_Two.setOnClickListener {
            showToast(2)
        }

        button_Tree.setOnClickListener {
            showToast(3)
        }

    }

    var counter = 1

    fun showToast(answer: Int) {
        if (answer == rightAnswers.get(questionNo)) {
            Toast.makeText(applicationContext, "CORRECT!", Toast.LENGTH_SHORT).show()
            this.updateQuestion()
            counter += 1
        } else {
            Toast.makeText(applicationContext, "WRONGO!", Toast.LENGTH_SHORT).show()
        }
    }

    var questionNo = 0

    fun updateQuestion() {
        questionNo += 1
        val textQuest: TextView = findViewById(R.id.textField2)
        if (questionNo <= 3) {

            textQuest.setText(questions.get(questionNo))

        } else textQuest.setText("Показать результаты?")

        val result_Score: TextView = findViewById(R.id.button4)

var procent = counter*100/4

        result_Score.setOnClickListener {result_Score.text = "Ваш результат: ${procent} %"

        }

    }
}