package com.pokotechnologies.sgdatausage.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiServiceResponse {

    companion object {
        var BASE_URL = "https://data.gov.sg/api/action/"
        var client: OkHttpClient = OkHttpClient()
        fun create(): ApiClient {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()

            return retrofit.create(ApiClient::class.java)
        }
    }
}

