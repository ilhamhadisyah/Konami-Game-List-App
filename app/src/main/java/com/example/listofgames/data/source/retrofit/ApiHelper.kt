package com.example.listofgames.data.source.retrofit

class ApiHelper(private val apiService: ApiService) {
    suspend fun getGamesData() = apiService.getGames()
}