package com.bilulo.desafioandroid.data

import com.bilulo.desafioandroid.data.api.ApiResult
import com.bilulo.desafioandroid.data.model.CharacterResponse

class MarvelRepository(private val datasource: IMarvelDatasource) {

    suspend fun getCharacters(offset: Int = 0): ApiResult<CharacterResponse> =
        datasource.getCharacters(offset)

}
