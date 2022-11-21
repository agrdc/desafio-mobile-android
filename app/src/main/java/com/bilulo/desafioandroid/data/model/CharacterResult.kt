package com.bilulo.desafioandroid.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: CharacterThumbnail?,
)
