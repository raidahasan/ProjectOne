package com.example.projectone

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var main: LinearLayout
    private lateinit var score: TextView
    private lateinit var strikes: TextView
    private lateinit var button: Button
    private lateinit var instructions: TextView
    private lateinit var boxOne: TextView
    private lateinit var boxTwo: TextView
    private var scoreCount: Int = 0
    private var strikeCount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        main= findViewById(R.id.main)
        score = findViewById(R.id.score)
        strikes = findViewById(R.id.strikes)
        button = findViewById(R.id.button)
        instructions = findViewById(R.id.instructions)
        boxOne = findViewById(R.id.boxOne)
        boxTwo = findViewById(R.id.boxTwo)
        /*
        var on = false;

        button.setOnClickListener{
            if(on){
                (it as TextView).text = "Start"
                on = false;
                game()
            }else{
                (it as TextView).text = "Restart"
                on = true;
                game()
            }
        }
        */


    }

    private fun game(){
        val randOne = Math.floor(Math.random()*100)+1
        val randTwo = Math.floor(Math.random()*100)+1
        boxOne.text = randOne.toString()
        boxTwo.text = randTwo.toString()
        boxOne.setOnClickListener{
            if(randOne>=randTwo){
                scoreCount++
            }else{
                strikeCount++
            }
        }

        boxTwo.setOnClickListener{
            if(randTwo>=randOne){
                scoreCount++
            }else{
                strikeCount++
            }
        }
    }

}