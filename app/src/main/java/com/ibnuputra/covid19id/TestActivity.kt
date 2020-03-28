package com.ibnuputra.covid19id

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView

class TestActivity : AppCompatActivity() {
    private lateinit var tvSoal: TextView
    private lateinit var btnYes: CardView
    private lateinit var btnNo: CardView
    private var questionData: MutableList<String> = ArrayList()
    private var posQuest: Int = 0
    private var point:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        tvSoal = findViewById(R.id.tvQuest)
        btnYes = findViewById(R.id.btnYes)
        btnNo = findViewById(R.id.btnNo)

        questionData.add("Apakah Anda mengalami sesak nafas?")
        questionData.add("Apakah Anda mengalami demam tinggi?")
        questionData.add("Apakah Anda mengalami batuk kering?")
        questionData.add("Apakah Anda mengalami flu?")
        questionData.add("Apakah tubuh Anda terasa lemas?")
        questionData.add("Apakah terasa pegal pada persendian?")
        questionData.add("Apakah Anda merasa Mual?")
        questionData.add("Apakah Anda mengalami gejala diatas lebih dari 14 hari?")

        tvSoal.text = questionData[posQuest]


        btnYes.setOnClickListener {
            point += when (posQuest) {
                1 -> {
                    18
                }
                2 -> {
                    18
                }
                else -> {
                    10
                }
            }
            posQuest+=1
            getSoal()
        }
        btnNo.setOnClickListener {
            posQuest+=1
            getSoal()
        }
    }

    fun getSoal(){
        Log.d("TAG", "PTS : $point")
        tvSoal.text = questionData[posQuest]
    }
}
