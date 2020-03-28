package com.ibnuputra.covid19id.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.ibnuputra.covid19id.R
import com.ibnuputra.covid19id.TestActivity

class TestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.test_fragment, container, false)
        val goTest: CardView = view.findViewById(R.id.goTest)

        goTest.setOnClickListener {
            val intent = Intent(context, TestActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}