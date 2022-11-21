package com.bilulo.desafioandroid.data.model

import com.google.gson.annotations.SerializedName

data class CharacterThumbnail(
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,

    val extensionEnum: ThumbnailExtension? = ThumbnailExtension.fromValue(extension)
)

enum class ThumbnailExtension(val value: String?) {
    GIF("gif"),
    Jpg("jpg");

    companion object {
        fun fromValue(value: String?): ThumbnailExtension? = when (value) {
            "gif" -> GIF
            "jpg" -> Jpg
            else  -> null
        }

        fun isGif(value: String): Boolean = when (value) {
            "gif" -> true
            "jpg" -> false
            else  -> throw IllegalArgumentException()
        }
    }
}
