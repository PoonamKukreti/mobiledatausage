package com.pokotechnologies.sgdatausage.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


abstract class Results : List<YearDataUsage> {

    @SerializedName("records")
    @Expose
    var recordList: List<QuarterUsageRecord>? = null

    inner class QuarterUsageRecord {
        @SerializedName("volume_of_mobile_data")
        @Expose
        var dataVolume: String? = null

        @SerializedName("quarter")
        @Expose
        var quarter: String? = null

    }

}