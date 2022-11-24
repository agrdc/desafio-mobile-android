package com.bilulo.desafioandroid.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bilulo.desafioandroid.R
import com.bilulo.desafioandroid.data.api.ApiResult
import com.bilulo.desafioandroid.data.model.CharacterResult
import com.bilulo.desafioandroid.domain.GetCharactersCarouselItemsUsecase
import com.bilulo.desafioandroid.domain.GetMarvelCharactersUsecase
import kotlinx.coroutines.launch
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainViewModel(
    private val getMarvelCharactersUsecase: GetMarvelCharactersUsecase,
    private val getCharactersCarouselItemsUsecase: GetCharactersCarouselItemsUsecase
) : ViewModel() {

    private val loadingStateMutableLiveData = MutableLiveData<LoadingState>()
    val loadingStateLiveData: LiveData<LoadingState> get() = loadingStateMutableLiveData

    private val errorStateMutableLiveData = MutableLiveData<ErrorState>()
    val errorStateLiveData: LiveData<ErrorState> get() = errorStateMutableLiveData

    private val successStateMutableLiveData = MutableLiveData<SuccessState>()
    val successStateLiveData: LiveData<SuccessState> get() = successStateMutableLiveData

    private lateinit var carouselItemList: List<CarouselItem>

    fun getMarvelCharacters(offset: Int = 0) {
        viewModelScope.launch {
            loadingStateMutableLiveData.value = LoadingState()
            when (val response = getMarvelCharactersUsecase.execute(offset)) {
                is ApiResult.Error -> {
                    loadingStateMutableLiveData.value = LoadingState(isLoading = false)
                    errorStateMutableLiveData.value = ErrorState(R.string.api_error)
                }
                is ApiResult.Success -> {
                    getCarouselItemList(response.data.data?.resultList)
                    loadingStateMutableLiveData.value = LoadingState(isLoading = false)
                    successStateMutableLiveData.value = SuccessState(
                        carouselList = carouselItemList,
                        //TODO
                        charactersList = listOf()
                    )
                }
            }
        }
    }

    private fun getCarouselItemList(resultList: List<CharacterResult>?) {
        if (!::carouselItemList.isInitialized) {
            carouselItemList =
                getCharactersCarouselItemsUsecase.execute(resultList)
        }
    }
}