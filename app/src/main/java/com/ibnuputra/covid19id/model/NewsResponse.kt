package com.ibnuputra.covid19id.model

import com.google.gson.annotations.SerializedName

class NewsResponse(
    @SerializedName("title")
    var title: String? = null,

    @SerializedName("description")
    var deskripsi: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("urlToImage")
    var thumbnail: String? = null,

    @SerializedName("author")
    var penulis: String? = null
)