package com.pokotechnologies.sgdatausage.rest

import com.pokotechnologies.sgdatausage.model.DataUsageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("datastore_search")
    fun getMobileDataUsage(@Query("resource_id") resourceId: String,
                           @Query("limit")limit:String): Call<DataUsageResponse>
}
