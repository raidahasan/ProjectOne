package com.example.projectone

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var main: ConstraintLayout
    private lateinit var score: TextView
    private lateinit var strikes: TextView
    private lateinit var button: Button
    private lateinit var instructions: TextView
    private lateinit var boxOne: TextView
    private lateinit var boxTwo: TextView
    private var scoreCount: Int = 0
    private var strikeCount: Int = 0
    private var randOne = ((Math.random()*100)+1).toInt()
    private var randTwo = ((Math.random()*100)+1).toInt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        main = findViewById(R.id.main)
        score = findViewById(R.id.score)
        strikes = findViewById(R.id.strikes)
        button = findViewById(R.id.button)
        instructions = findViewById(R.id.instructions)
        boxOne = findViewById(R.id.boxOne)
        boxTwo = findViewById(R.id.boxTwo)
        var on = false;

        button.setOnClickListener{
            if(on){
                game()
                strikeCount = 0
                scoreCount = 0
                strikes.text = "Strikes: $strikeCount"
                score.text = "Score: $scoreCount"
                strikes.setTextColor(Color.BLACK)
                score.setTextColor(Color.BLACK)
            }else{
                (it as TextView).text = "Restart"
                on = true;
                game()
            }
        }

    }

    private fun game(){
        randOne = ((Math.random()*100)+1).toInt()
        randTwo = ((Math.random()*100)+1).toInt()
        boxOne.text = randOne.toString()
        boxTwo.text = randTwo.toString()
        instructions.text = "Tap the larger number!"
        boxOne.setOnClickListener{
            if(randOne>=randTwo){
                scoreCount++
                main.setBackgroundColor(Color.GREEN)
                score.setTextColor(Color.WHITE)
                strikes.setTextColor(Color.BLACK)
            }else{
                strikeCount++
                main.setBackgroundColor(Color.RED)
                score.setTextColor(Color.BLACK)
                strikes.setTextColor(Color.WHITE)
            }
            newNums()
            ending()
        }

        boxTwo.setOnClickListener{
            if(randTwo>=randOne){
                scoreCount++
                main.setBackgroundColor(Color.GREEN)
                score.setTextColor(Color.WHITE)
                strikes.setTextColor(Color.BLACK)
            }else{
                strikeCount++
                main.setBackgroundColor(Color.RED)
                score.setTextColor(Color.BLACK)
                strikes.setTextColor(Color.WHITE)
            }
            newNums()
            ending()
        }
    }
    fun ending(){
        if(strikeCount == 3){
            val toast: Toast = Toast.makeText(this, "Sorry, you lost.", Toast.LENGTH_SHORT)
            toast.show()
            boxOne.setOnClickListener(null)
            boxTwo.setOnClickListener(null)
            boxOne.text = ""
            boxTwo.text = ""
            main.setBackgroundColor(Color.parseColor("#DEEDEDA7"))
            score.setTextColor(Color.BLACK)
            strikes.setTextColor(Color.RED)
            instructions.text = "Tap Restart to play again!"
        }else if (scoreCount == 10){
            val toast: Toast = Toast.makeText(this, "Congrats, you win!.", Toast.LENGTH_SHORT)
            toast.show()
            boxOne.setOnClickListener(null)
            boxTwo.setOnClickListener(null)
            boxOne.text = ""
            boxTwo.text = ""
            main.setBackgroundColor(Color.parseColor("#DEEDEDA7"))
            score.setTextColor(Color.GREEN)
            strikes.setTextColor(Color.BLACK)
            instructions.text = "Tap Restart to play again!"

        }
    }

    fun newNums(){
        strikes.text = "Strikes: $strikeCount"
        score.text = "Score: $scoreCount"
        randOne = ((Math.random()*100)+1).toInt()
        randTwo = ((Math.random()*100)+1).toInt()
        boxOne.text = randOne.toString()
        boxTwo.text = randTwo.toString()
    }
}