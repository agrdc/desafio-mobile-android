package com.bilulo.desafioandroid.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("attributionText") val attributionText: String?,
    @SerializedName("data") val data: CharacterDataResponse?
)