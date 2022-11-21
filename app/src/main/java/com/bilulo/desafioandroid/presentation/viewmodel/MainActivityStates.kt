package com.bilulo.desafioandroid.presentation.viewmodel

import com.bilulo.desafioandroid.data.model.CharacterResult

sealed class MainActivityState {
    data class LoadingState(
        var isLoading: Boolean = true
    ) : MainActivityState()
    data class SuccessState(
        var carouselList: List<CharacterResult>,
        var charactersList: List<CharacterResult>
    ) : MainActivityState()
}
