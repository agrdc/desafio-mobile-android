package com.bilulo.desafioandroid.data.api

sealed class ApiResult<T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error<T>(val errorMessage: String?) : ApiResult<T>()
}