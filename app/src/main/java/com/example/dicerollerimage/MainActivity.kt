package com.example.dicerollerimage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}
    }

    private fun rollDice(){
        val  randomInt = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val edtNumber: EditText = findViewById(R.id.edtNumber)

        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        if (edtNumber.length() != 0)
        {
            if (randomInt == Integer.parseInt(edtNumber.text.toString()))
            {
                Toast.makeText(this, "You Win", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Your Lose", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this, "Informe seu número da sorte", Toast.LENGTH_SHORT).show()
        }

        diceImage.setImageResource(drawableResource)
    }
}