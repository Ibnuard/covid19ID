package com.ibnuputra.covid19id

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView

class TestResultActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)

        var hasil = intent.getIntExtra("PTS", 0)

        val numResult: TextView = findViewById(R.id.numResult)
        val tvTitle: TextView = findViewById(R.id.tvTitleResult)
        val tvDesc: TextView = findViewById(R.id.tvDescResult)
        val btnBack: CardView = findViewById(R.id.backToMenu)

        btnBack.setOnClickListener {
            onBackPressed()
            finish()
        }

        if (hasil < 60){
            numResult.text = "$hasil%"
            tvTitle.text = "Anda Terindikasi Sehat!"
            tvDesc.text = "Kondisi Anda dalam keadaan sehat dan terhindar dari virus Covid19, Terus jaga kesehatan Anda dengan rajin berolahraga dan makan makanan yang sehat."
        }else{
            numResult.text = "$hasil%"
            tvTitle.text = "Anda Mengalami Gejala!"
            tvDesc.text = "Jangan panik! Segara periksakan diri Anda ke rumah sakit terdekat untuk mengetahui keadaan Anda lebih lanjut. Selalu jaga kebersihan dan makan makanan yang sehat."
        }
    }
}
