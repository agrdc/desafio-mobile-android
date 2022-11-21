package com.bilulo.desafioandroid.data.api

import com.bilulo.desafioandroid.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("apikey") apikey: String = API_KEY,
        @Query("hash") hash: String = API_KEY_MD5,
        @Query("ts") ts: String = "1"
    ) : CharacterResponse
}