package com.bilulo.desafioandroid

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bilulo.desafioandroid.databinding.ActivityMainBinding
import com.bilulo.desafioandroid.presentation.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject()
    private lateinit var bind: ActivityMainBinding
    private lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.getMarvelCharacters()

        viewModel.successStateLiveData.observe(this) { successState ->
            bind.carousel.setData(successState.carouselList)
        }

        viewModel.errorStateLiveData.observe(this) { errorState ->
            setupSnackbar(getString(errorState.errorMessageResourceId))
            snackbar.show()
        }

        viewModel.loadingStateLiveData.observe(this) { loadingState ->
            when (loadingState.isLoading) {
                true -> {
                    bind.progressBar.visibility = View.VISIBLE
                }
                false -> {
                    bind.progressBar.visibility = View.GONE
                }
            }
        }
    }

    private fun setupSnackbar(errorMessage: String) {
        if (!::snackbar.isInitialized) {
            snackbar = Snackbar.make(
                bind.root,
                errorMessage,
                Snackbar.LENGTH_LONG
            )
            snackbar.setTextColor(Color.WHITE)
            snackbar.setBackgroundTint(Color.RED)
        }
    }
}