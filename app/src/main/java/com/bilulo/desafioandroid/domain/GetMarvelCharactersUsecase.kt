package com.bilulo.desafioandroid.domain

import com.bilulo.desafioandroid.data.MarvelRepository
import com.bilulo.desafioandroid.data.api.ApiResult
import com.bilulo.desafioandroid.data.model.CharacterResponse

class GetMarvelCharactersUsecase(private val repository: MarvelRepository) {
    suspend fun execute(offset: Int = 0) : ApiResult<CharacterResponse> {
        return repository.getCharacters(offset)
    }
}