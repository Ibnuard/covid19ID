package com.ibnuputra.covid19id.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.ibnuputra.covid19id.GuideView
import com.ibnuputra.covid19id.R
import com.ibnuputra.covid19id.model.CoronaResponse
import com.ibnuputra.covid19id.service.ApiMain
import com.mancj.slimchart.SlimChart
import kotlinx.android.synthetic.main.home_fragment.*
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var pieChart: SlimChart
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.home_fragment, container, false)
        pieChart = view.findViewById(R.id.slimChart)
        val guideBtn: CardView = view.findViewById(R.id.guideButton)

        guideBtn.setOnClickListener {
            val intent = Intent(context, GuideView::class.java)
            context?.startActivity(intent)
        }

        ApiMain().services.getStats().enqueue(object :
            retrofit2.Callback<List<CoronaResponse>> {
            override fun onFailure(call: Call<List<CoronaResponse>>, t: Throwable) {
                Toast.makeText(context, "GAGAL $t", Toast.LENGTH_SHORT).show()
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<List<CoronaResponse>>,
                response: Response<List<CoronaResponse>>
            ) {
                val data = response.body()
                data?.map {
                    Log.d("tag", "datanya ${it.deaths}")
                    val death = it.deaths
                    val totalCase = it.confirmed
                    val activeCase = it.active
                    val recovered = it.recovered
                    setData(death, totalCase, activeCase, recovered)

                    tvActive.text = activeCase.toString()
                    tvTotal.text = totalCase.toString()
                    tvDeath.text = death.toString()
                    tvRecovered.text = recovered.toString()
                    lastUpdate.text = "Terakhir di update : ${TimeAgo.using(it.lastUpdate!!.toLong())}"
                }
            }
        })

        return view
    }

    private fun setData(death: Int?, totalCase: Int?, active: Int?, recovered: Int?) {
        val statDeath = (death!!.toFloat()/totalCase!!.toFloat())*100
        val statRecovered = (recovered!!.toFloat()/totalCase.toFloat())*100
        val statActive = (active!!.toFloat()/totalCase.toFloat())*100



        val stats = FloatArray(4)
        stats[0] = statActive+statDeath+statRecovered
        stats[1] = statDeath+statRecovered
        stats[2] = statRecovered

        val colors = IntArray(4)
        colors[0] = resources.getColor(R.color.colorOrange)
        colors[1] = resources.getColor(R.color.colorRed)
        colors[2] = resources.getColor(R.color.colorGreen)

        pieChart.text = totalCase.toString()
        pieChart.colors = colors
        pieChart.stats = stats
        pieChart.setStartAnimationDuration(2000)
        pieChart.playStartAnimation()

    }

}