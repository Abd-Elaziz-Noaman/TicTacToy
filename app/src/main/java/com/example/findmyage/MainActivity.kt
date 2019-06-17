package com.example.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    fun play(view: View){

        var butChoice= view as Button
        var CellId=0
        when (butChoice.id){
            R.id.button1-> CellId=1
            R.id.button2-> CellId=2
            R.id.button3-> CellId=3
            R.id.button4-> CellId=4
            R.id.button5-> CellId=5
            R.id.button6-> CellId=6
            R.id.button7-> CellId=7
            R.id.button8-> CellId=8
            R.id.button9-> CellId=9


        }
        PlayGame(CellId,butChoice)
        AutoPlay()
    }

    var play1=ArrayList<Int>()
    var play2=ArrayList<Int>()
    var activePlayer=1

    fun PlayGame(cellId:Int,butChoice:Button){

        if (activePlayer==1){
            butChoice.text="X"
            butChoice.setBackgroundResource(R.color.red)
            play1.add(cellId)
            activePlayer=2

        }else{
            butChoice.text="O"
            butChoice.setBackgroundResource(R.color.black)
            play2.add(cellId)
            activePlayer=1
        }

        butChoice.isEnabled=false
        CheckWinner()

    }

    fun CheckWinner() {


        var winner = 0
        if (play1.contains(1) && play1.contains(2) && play1.contains(3)) {
            winner = 1
        }
        if (play2.contains(1) && play2.contains(2) && play2.contains(3)) {
            winner = 2
        }

        if (play1.contains(4) && play1.contains(5) && play1.contains(6)) {
            winner = 1
        }
        if (play2.contains(4) && play2.contains(5) && play2.contains(6)) {
            winner = 2
        }

        if (play1.contains(7) && play1.contains(8) && play1.contains(9)) {
            winner = 1
        }
        if (play2.contains(7) && play2.contains(8) && play2.contains(9)) {
            winner = 2
        }

        if (play1.contains(1) && play1.contains(4) && play1.contains(7)) {
            winner = 1
        }
        if (play2.contains(1) && play2.contains(4) && play2.contains(7)) {
            winner = 2
        }

        if (play1.contains(2) && play1.contains(5) && play1.contains(8)) {
            winner = 1
        }
        if (play2.contains(2) && play2.contains(5) && play2.contains(8)) {
            winner = 2
        }

        if (play1.contains(3) && play1.contains(6) && play1.contains(9)) {
            winner = 1
        }
        if (play2.contains(3) && play2.contains(6) && play2.contains(9)) {
            winner = 2
        }

        Log.e("TAG","checkWinner  $winner")

            if (winner == 1) {
                Log.e("TAG","checkWinner1")

                Toast.makeText(this, "player 1 is win ", Toast.LENGTH_LONG).show()
            } else if (winner==2){
                Toast.makeText(this, "player 2 is win ", Toast.LENGTH_LONG).show()
                Log.e("TAG","checkWinner2")

            }

        }

    fun AutoPlay(){


        var emptyCells=ArrayList<Int>()
        for (index in 0..9) {
            if (!(play1.contains(index) || play2.contains(index))) {

                emptyCells.add(index)
                println(emptyCells.size)
            }
        }
            val r =Random()
            val rIndex=r.nextInt(emptyCells.size-0)

            val cellId=emptyCells[rIndex]

            var butSelect:Button?
            when(cellId){
                1->butSelect=button1
                2->butSelect=button2
                3->butSelect=button3
                4->butSelect=button4
                5->butSelect=button5
                6->butSelect=button6
                7->butSelect=button7
                8->butSelect=button8
                9->butSelect=button9

                else ->{
                    butSelect=button1
                }
            }


            PlayGame(cellId,butSelect)



    }

}
