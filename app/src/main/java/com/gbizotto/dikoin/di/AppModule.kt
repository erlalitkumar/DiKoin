package com.gbizotto.dikoin.di

import com.gbizotto.dikoin.feature.main.viewmodel.MainViewModel
import com.gbizotto.dikoin.repository.HelloRepository
import com.gbizotto.dikoin.repository.HelloRepositoryImpl
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val appModule = module {

    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // MyViewModel ViewModel
    viewModel { MainViewModel(get()) }
}