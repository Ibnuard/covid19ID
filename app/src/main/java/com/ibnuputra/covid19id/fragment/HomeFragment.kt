package com.ibnuputra.covid19id.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ibnuputra.covid19id.R
import com.ibnuputra.covid19id.model.CoronaResponse
import com.ibnuputra.covid19id.service.ApiMain
import lecho.lib.hellocharts.view.PieChartView
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var pieChart: PieChartView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.home_fragment, container, false)
        pieChart


        ApiMain().services.getStats().enqueue(object :
            retrofit2.Callback<List<CoronaResponse>> {
            override fun onFailure(call: Call<List<CoronaResponse>>, t: Throwable) {
                Toast.makeText(context, "GAGAL $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<CoronaResponse>>,
                response: Response<List<CoronaResponse>>
            ) {
                val data = response.body()
                data?.map {
                    Log.d("tag", "datanya ${it.confirmed}")
                }
            }
        })

        return view
    }

}