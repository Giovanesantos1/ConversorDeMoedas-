package com.example.fintrack

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("latest")
    suspend fun getExchangeRates(
        @Query("access_key") apiKey: String,
        @Query("base") baseCurrency: String = "SGD"
    ): Response<ExchangeRateResponse>

}