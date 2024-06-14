package com.example.demoassignment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
   private const val BASE_URL = "https://machintestapi.erpguru.in"

   val apiService: ApiService by lazy {
      Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create(ApiService::class.java)
   }
}
