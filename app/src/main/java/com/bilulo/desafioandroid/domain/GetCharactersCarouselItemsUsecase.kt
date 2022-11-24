package com.bilulo.desafioandroid.domain

import com.bilulo.desafioandroid.data.model.CharacterResult
import com.bilulo.desafioandroid.data.model.ThumbnailExtension
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class GetCharactersCarouselItemsUsecase(private val formatCharacterImageUrlUsecase: FormatCharacterImageUrlUsecase) {
    fun execute(fullList: List<CharacterResult>?): List<CarouselItem> {
        return if (fullList.isNullOrEmpty()) {
            return listOf()
        } else {
            val carouselItemList = mutableListOf<CarouselItem>()
            fullList.map { result ->
                buildCarouseItemList(result, carouselItemList)
            }
            carouselItemList.toList()
        }
    }

    private fun buildCarouseItemList(
        result: CharacterResult,
        carouselItemList: MutableList<CarouselItem>
    ) {
        result.thumbnail?.let { thumbnail ->
            if (ThumbnailExtension.isJpg(ThumbnailExtension.fromValue(thumbnail.extension))) {
                if (carouselItemList.size < 5) {
                    val formattedUrl = formatCharacterImageUrlUsecase.execute(thumbnail)
                    if (formattedUrl.isNotBlank()) {
                        carouselItemList.add(
                            CarouselItem(
                                imageUrl = formattedUrl,
                                result.name
                            )
                        )
                    }
                }
            }
        }
    }
}
