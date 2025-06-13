package com.sabahattinay.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.rollButton)

        rollButton.setOnClickListener { rollDice() }

    }

    private fun rollDice() {

        val dice = Dice(6)
        val diceRoll = dice.roll()


        val diceImage = findViewById<ImageView>(R.id.diceImage)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)


            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_one
                2 -> R.drawable.dice_two
                3 -> R.drawable.dice_three
                4 -> R.drawable.dice_four
                5 -> R.drawable.dice_five
                else -> R.drawable.dice_six

            }

            diceImage.setImageResource(drawableResource)

            diceImage.contentDescription = diceRoll.toString()

            resultTextView.text = diceRoll.toString()

        }
    }


    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
