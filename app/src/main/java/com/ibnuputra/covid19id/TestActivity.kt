package com.ibnuputra.covid19id

import android.content.Intent
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
    private var point = 0

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

        tvSoal.text = questionData[posQuest]

        btnYes.setOnClickListener {
            point += when (posQuest) {
                0 -> {
                    25
                }
                1 -> {
                    25
                }
                else -> {
                    10
                }
            }
            posQuest+=1
            getSoal()
        }
        btnNo.setOnClickListener {
            posQuest += 1
            getSoal()
        }
    }

    private fun getSoal(){
        Log.d("TAG", "PTS PER $posQuest : $point")
        if (posQuest<questionData.size){
            tvSoal.text = questionData[posQuest]
        }else{
            val intent = Intent(this, TestResultActivity::class.java)
            intent.putExtra("PTS", point)
            startActivity(intent)
            finish()
        }
    }
}
