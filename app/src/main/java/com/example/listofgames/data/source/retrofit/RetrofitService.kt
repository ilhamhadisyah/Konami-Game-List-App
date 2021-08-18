package com.example.listofgames.data.source.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL = "https://sfile.mobi/downIoad/843432/461736/b45bc4e0e543bc823ca6b3d69a3fe38f/games.json&is=8d487939b03d72e4ee2e604a874d80c4/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService : ApiService = getRetrofit().create(ApiService::class.java)
}