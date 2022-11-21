package com.bilulo.desafioandroid.data

import com.bilulo.desafioandroid.data.api.ApiResult
import com.bilulo.desafioandroid.data.model.CharacterResponse

interface IMarvelDatasource {
    suspend fun getCharacters(offset: Int = 0) : ApiResult<CharacterResponse>
}