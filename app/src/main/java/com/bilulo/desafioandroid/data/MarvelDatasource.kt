package com.bilulo.desafioandroid.data

import android.util.Log
import com.bilulo.desafioandroid.data.api.ApiResult
import com.bilulo.desafioandroid.data.api.MarvelApi
import com.bilulo.desafioandroid.data.api.retrofit.RetrofitClient
import com.bilulo.desafioandroid.data.model.CharacterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelDatasource(
    private val retrofitClient: RetrofitClient,
    private val api: MarvelApi = retrofitClient.retrofit.create(MarvelApi::class.java)
) : IMarvelDatasource {

    override suspend fun getCharacters(offset: Int): ApiResult<CharacterResponse> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.getCharacters(offset)
                ApiResult.Success(response)
            } catch (e: Exception) {
                Log.e(this.javaClass.name, e.message ?: e.localizedMessage ?: "")
                ApiResult.Error(e.message)
            }
        }
}