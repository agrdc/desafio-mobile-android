package com.bilulo.desafioandroid.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bilulo.desafioandroid.data.api.ApiResult
import com.bilulo.desafioandroid.domain.GetMarvelCharactersUsecase
import kotlinx.coroutines.launch

class MainViewModel(private val getMarvelCharactersUsecase: GetMarvelCharactersUsecase) :
    ViewModel() {

    private val stateMutableLiveData = MutableLiveData<MainActivityState>()
    val stateLiveData: LiveData<MainActivityState> get() = stateMutableLiveData

    fun getMarvelCharacters(offset: Int = 0) {
        viewModelScope.launch {
            stateMutableLiveData.postValue(MainActivityState.LoadingState())
            when (val response = getMarvelCharactersUsecase.execute(offset)) {
                is ApiResult.Error -> {
                    TODO()
                }
                is ApiResult.Success -> {
                    TODO()
                }
            }
        }
    }
}