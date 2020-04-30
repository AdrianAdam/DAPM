package com.example.adrianadam.lab4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    // 0 = x, 1 = o
    var activePlayer = 0
    var gameIsActive = true
    // 2 unplayed
    var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var winningPositions = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    lateinit var tv_winner: TextView
    lateinit var linear_layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_winner = findViewById(R.id.tv_winner)
        var btn_play_again: Button = findViewById(R.id.btn_play_again)
        linear_layout = findViewById(R.id.linear_layout)
        var grid_layout: GridLayout = findViewById(R.id.grid_layout)

        btn_play_again.setOnClickListener({
            gameIsActive = true
            gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
            activePlayer = 0
            linear_layout.visibility = View.INVISIBLE

            for(i in 0..grid_layout.childCount)
            {
                (grid_layout.getChildAt(i) as ImageView).setImageResource(0)
            }
        })
    }

    fun dropIn(view: View) {
        val counter = view as ImageView
        // get the current Image View (counter tag)
        val tappedCounter = Integer.parseInt(counter.getTag().toString())

        //if the space is empty(is 2) and the game is not over
        if (gameState[tappedCounter] === 2 && gameIsActive) {
            //set the current player
            gameState[tappedCounter] = activePlayer
            if (activePlayer === 0) {
                // setImageResource for counter as x
                // TODO
                activePlayer = 1

                counter.setImageResource(R.drawable.ic_x)
            } else {
                // setImageResource for counter as zero
                // TODO
                activePlayer = 0

                counter.setImageResource(R.drawable.ic_0)
            }
            for (winningPosition in winningPositions) {
                if (gameState[winningPosition[0]] === gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] === gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] !== 2
                ) {
                    // Someone has won!
                    gameIsActive = false
                    var winner = "Player1 -> 0"

                    if (gameState[winningPosition[0]] === 0) {
                        winner = "Player2 -> x"
                    }
                    // Make a toast with the messaje winner + " has won!"
                    //TODO

                    tv_winner.text = "The winner is " + winner
                    linear_layout.visibility = View.VISIBLE
                } else {
                    var gameIsOver = true

                    for (counterState in gameState) {
                        if (counterState == 2)
                            gameIsOver = false
                    }
                    if (gameIsOver) {
                        // Make a toast with the messaje "It's a draw!"
                        //TODO

                        tv_winner.text = "It's a draw!"
                        linear_layout.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
