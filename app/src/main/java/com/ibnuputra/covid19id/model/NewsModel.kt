package com.ibnuputra.covid19id.model

import com.google.gson.annotations.SerializedName

class NewsModel(
    @SerializedName("status")
    var status: String? = null,

    @SerializedName("totalResult")
    var totalResult: Int? = null,

    @SerializedName("articles")
    var articles: List<NewsResponse>? = null
)