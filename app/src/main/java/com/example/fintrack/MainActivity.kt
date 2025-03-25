package com.example.fintrack

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            try {
                val response = RetrofitClient.instance.getExchangeRates(BuildConfig.API_KEY)
                if (response.isSuccessful) {
                    val exchangeRates = response.body()
                    Log.d("API_RESPONSE", "Taxa de câmbio: ${exchangeRates?.rates?.get("USD")}")
                } else {
                    Log.e("API_ERROR", "Erro na resposta: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("API_EXCEPTION", "Erro ao chamar API: ${e.message}")
            }
        }
    }
}