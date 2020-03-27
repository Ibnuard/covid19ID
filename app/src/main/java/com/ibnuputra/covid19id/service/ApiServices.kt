package com.ibnuputra.covid19id.service

import com.ibnuputra.covid19id.model.CoronaResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("api/countries/indonesia/confirmed")
    fun getStats() : Call<List<CoronaResponse>>
}