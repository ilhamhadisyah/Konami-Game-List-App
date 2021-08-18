package com.example.listofgames.data.source.retrofit
import com.example.listofgames.data.model.GameModelItem
import com.example.listofgames.data.model.ResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET(" ")
    suspend fun getGames(): List<GameModelItem>
}