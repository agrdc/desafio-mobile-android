package com.bilulo.desafioandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bilulo.desafioandroid.presentation.viewmodel.MainActivityState
import com.bilulo.desafioandroid.presentation.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getMarvelCharacters()

        viewModel.stateLiveData.observe(this) { state ->
            when (state) {
                is MainActivityState.LoadingState -> {
                    TODO()
                }
                is MainActivityState.SuccessState -> {
                    TODO()
                }
            }
        }
    }
}