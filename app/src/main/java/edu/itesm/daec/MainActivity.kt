package edu.itesm.daec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val player1 = "Jugador 1"
    val player2 = "Jugador 2"
    var tirosPartida = 1
    var tiroP1 = 0
    var tiroP2 = 0
    var scoreP1 = 0
    var scoreP2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("edu.itesm.daec", "demostracion de log")
        //test_kotlin()
        tira_dado()
    }

    fun tira_dado(){


        roll_dice.setOnClickListener {
            if (tirosPartida < 7){
                val rand = Random.nextInt(1, 7)
                var player = if (tirosPartida % 2 == 0){
                    tiroP2++
                    scoreP2 += rand
                    "$player2 \n Tiro # $tiroP2 \n Score: $scoreP2"
                } else {
                    tiroP1++
                    scoreP1 += rand
                    "$player1 \n Tiro # $tiroP1 \n Score: $scoreP1"
                }
                mensaje.text = "$player \n Dado: $rand"
                tirosPartida++
            } else {
                val winner = checkWinner(scoreP1, scoreP2)
                mensaje.text = "Ganador: $winner"
                restartGame()
            }
        }
    }

    fun checkWinner(score1: Int, score2: Int): String{
        var winner = ""
        if (score1 > score2){
            winner = "$player1"
        } else if (score1 == score2){
            winner = "es un empate"
        } else {
            winner = "$player2"
        }
        return winner
    }

    fun restartGame(){
        tirosPartida = 1
        tiroP1 = 0
        tiroP2 = 0
        scoreP1 = 0
        scoreP2 = 0
    }
}