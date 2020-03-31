package com.ibnuputra.covid19id

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView

class GuideListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_list)

        val coGuide: CardView = findViewById(R.id.coronaGuide)
        val soGuide: CardView = findViewById(R.id.sodiGuide)
        val tiguide: CardView = findViewById(R.id.tidiGuide)

        val goBack: ImageView = findViewById(R.id.goBack)

        goBack.setOnClickListener {
            onBackPressed()
            finish()
        }

        coGuide.setOnClickListener {
            val intent = Intent(this, GuideView::class.java)
            intent.putExtra("url", "file:///android_asset/corona.html")
            startActivity(intent)
        }
    }
}
