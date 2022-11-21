package com.bilulo.desafioandroid

import android.app.Application
import com.bilulo.desafioandroid.data.IMarvelDatasource
import com.bilulo.desafioandroid.data.MarvelDatasource
import com.bilulo.desafioandroid.data.MarvelRepository
import com.bilulo.desafioandroid.data.api.retrofit.RetrofitClient
import com.bilulo.desafioandroid.domain.GetMarvelCharactersUsecase
import com.bilulo.desafioandroid.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        val module = module {
            viewModel {
                MainViewModel(getMarvelCharactersUsecase = get())
            }
            factory { GetMarvelCharactersUsecase(repository = get()) }
            factory { MarvelRepository(datasource = get()) }
            single<IMarvelDatasource> { MarvelDatasource(retrofitClient = get()) }
            single { RetrofitClient() }
        }
        GlobalContext.startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules(module)
        }

    }
}