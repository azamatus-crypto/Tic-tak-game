package com.changeyourself.mykotlinfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

    fun onCklickButton1(view: android.view.View) {
      var celiId=0
        val buttonselect=view as Button
        when(buttonselect.id){
            R.id.button1->celiId=1
            R.id.button2->celiId=2
            R.id.button3->celiId=3
            R.id.button4->celiId=4
            R.id.button5->celiId=5
            R.id.button6->celiId=6
            R.id.button7->celiId=7
            R.id.button8->celiId=8
            R.id.button9->celiId=9
        }
      playGame(celiId,buttonselect)
    }
    var activeP=1
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var countPlayerscore=0
    var countDiveceScore=0
  fun playGame(cellID:Int,buttonselect:Button){
      if(activeP==1){
          buttonselect.text="X"
          buttonselect.setBackgroundResource(R.color.player1color)
          player1.add(cellID)
          activeP=2
          autoPlay()
      }else{
          buttonselect.text="O"
          buttonselect.setBackgroundResource(R.color.player2color)
          player2.add(cellID)
          activeP=1
      }
      buttonselect.isEnabled=false
      checkingWinner()
  }

    private fun autoPlay() {
        var emptyceels=ArrayList<Int>()
        for(i in 1..9){
            if(!player1.contains(i)||player2.contains(i)){
                emptyceels.add(i)
            }
        }
        val r=Random()
        val index=r.nextInt(emptyceels.size)
        val cellIdik=emptyceels[index]
        var buttonchik:Button?
        buttonchik=when(cellIdik){
            1->button1
            2->button2
            3->button3
            4->button4
            5->button5
            6->button6
            7->button7
            8->button8
            9->button9
            else->{button1}
        }
        playGame(cellIdik,buttonchik)
    }

    private fun checkingWinner() {
        var winner=-1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2
        }
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2
        }
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2
        }
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2
        }
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2
        }
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2
        }
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner=2
        }
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner=2
        }
        if(winner==1){
            countPlayerscore++
            Toast.makeText(this,"Player 1 is the winn game",Toast.LENGTH_LONG).show()
            restartGame()
            textViewPlayerScore.text="Player score is: $countPlayerscore"
        }
        else if(winner==2){
            countDiveceScore++
            Toast.makeText(this,"Player 2 is the winn game",Toast.LENGTH_LONG).show()
            restartGame()
            textViewDiviceScore.text="Divice Score is: $countDiveceScore"
        }
    }

    private fun restartGame() {
        activeP=1
        player1.clear()
        player2.clear()
      for(cellid in 1..9){
          var buttonchik:Button?
          buttonchik=when(cellid){
              1->button1
              2->button2
              3->button3
              4->button4
              5->button5
              6->button6
              7->button7
              8->button8
              9->button9
              else->{button1}
          }
          buttonchik!!.text=""
          buttonchik.setBackgroundResource(R.color.black)
          buttonchik!!.isEnabled=true
      }
    }
}