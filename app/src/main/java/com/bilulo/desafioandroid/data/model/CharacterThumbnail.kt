package com.bilulo.desafioandroid.data.model

import com.google.gson.annotations.SerializedName

data class CharacterThumbnail(
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,

)

enum class ThumbnailExtension(val value: String?) {
    GIF("gif"),
    Jpg("jpg"),
    None("");

    companion object {
        fun fromValue(value: String?): ThumbnailExtension = when (value) {
            "gif" -> GIF
            "jpg" -> Jpg
            else  -> None
        }

        fun isJpg(thumbnailExtension: ThumbnailExtension): Boolean = when (thumbnailExtension) {
            GIF -> false
            Jpg -> true
            else  -> false
        }
    }
}
