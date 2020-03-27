package com.ibnuputra.covid19id.service

import com.ibnuputra.covid19id.model.CoronaResponse
import com.ibnuputra.covid19id.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("api/countries/indonesia/confirmed")
    fun getStats() : Call<List<CoronaResponse>>

    @GET("top-headlines?country=id&category=health&apiKey=d03de803f7484f6c9f34b276aaa716ea")
    fun getNews() : Call<NewsModel>
}