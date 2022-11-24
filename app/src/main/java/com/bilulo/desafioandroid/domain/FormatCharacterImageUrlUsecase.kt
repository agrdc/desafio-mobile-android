package com.bilulo.desafioandroid.domain

import com.bilulo.desafioandroid.data.model.CharacterThumbnail

class FormatCharacterImageUrlUsecase {
    fun execute(thumbnail: CharacterThumbnail): String {
        thumbnail.path?.let { path ->
            return path.replace(
                "http",
                "https"
            ) + "." + thumbnail.extension
        }
        return ""
    }
}