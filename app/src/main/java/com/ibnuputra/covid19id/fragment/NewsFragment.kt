package com.ibnuputra.covid19id.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibnuputra.covid19id.R
import com.ibnuputra.covid19id.adapter.NewsAdapter
import com.ibnuputra.covid19id.model.NewsResponse
import com.ibnuputra.covid19id.service.ApiNews
import retrofit2.Call
import retrofit2.Response
import com.ibnuputra.covid19id.model.NewsModel as NewsModel1

class NewsFragment : Fragment() {
    var newsData: List<NewsResponse> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_fragment, container, false)
        val recyclerView = view.findViewById(R.id.recyclerview) as RecyclerView
        val loadText = view.findViewById(R.id.loadNews) as TextView

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = NewsAdapter(newsData, context!!)

        ApiNews().services.getNews().enqueue(object :
            retrofit2.Callback<NewsModel1> {
            override fun onFailure(call: Call<NewsModel1>, t: Throwable) {
            }

            override fun onResponse(call: Call<NewsModel1>, response: Response<NewsModel1>) {
                val data = response.body()
                newsData = data?.articles!!

                if (newsData.isNotEmpty()){
                    recyclerView.visibility = View.VISIBLE
                    loadText.visibility = View.GONE
                    recyclerView.adapter = NewsAdapter(newsData, context!!)
                }else{
                    recyclerView.visibility = View.GONE
                    loadText.visibility = View.VISIBLE
                }

            }

        })

        return view
    }
}