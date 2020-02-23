package com.pokotechnologies.sgdatausage.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DataUsageResponse {
    @SerializedName("result")
    @Expose
    var data: Results? = null



}
