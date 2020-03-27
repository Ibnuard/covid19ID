package com.ibnuputra.covid19id.model

import com.google.gson.annotations.SerializedName

class CoronaResponse(
    @SerializedName("provinceState")
    var provinceState: String? = null,

    @SerializedName("countryRegion")
    var countryRegion: String? = null,

    @SerializedName("lastUpdate")
    var lastUpdate: Number? = null,

    @SerializedName("lat")
    var lat: Float? = null,

    @SerializedName("long")
    var long: Float? = null,

    @SerializedName("confirmed")
    var confirmed: Int? = null,

    @SerializedName("recovered")
    var recovered: Int? = null,

    @SerializedName("deaths")
    var deaths: Int? = null,

    @SerializedName("active")
    var active: Int? = null,

    @SerializedName("admin2")
    var admin2: String? = null,

    @SerializedName("fips")
    var fips: String? = null,

    @SerializedName("combinedKey")
    var combinedKey: String? = null,

    @SerializedName("incidentRate")
    var incidentRate: Int? = null,

    @SerializedName("peopleTested")
    var peopleTested: Int? = null
)