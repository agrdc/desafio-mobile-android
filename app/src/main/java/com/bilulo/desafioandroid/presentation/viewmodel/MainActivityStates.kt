package com.bilulo.desafioandroid.presentation.viewmodel

import com.bilulo.desafioandroid.data.model.CharacterResult
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

data class LoadingState(
    var isLoading: Boolean = true
)

data class SuccessState(
    var carouselList: List<CarouselItem>,
    var charactersList: List<CharacterResult>
)

data class ErrorState(
    var errorMessageResourceId: Int,
)
