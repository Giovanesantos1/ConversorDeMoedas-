package com.example.fintrack

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "http://data.fixer.io/api/"

object RetrofitClient {

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

        retrofit.create(ApiService::class.java)
            }

}