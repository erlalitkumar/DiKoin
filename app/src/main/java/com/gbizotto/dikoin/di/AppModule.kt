package com.gbizotto.dikoin.di

import com.gbizotto.dikoin.feature.main.MainViewModel
import com.gbizotto.dikoin.repository.*
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }
    single<PlaceholderRepository> { PlaceholderRepositoryImpl(providePlaceholderApi()) }

    // MyViewModel ViewModel
    viewModel { MainViewModel(get(), get()) }
}

fun providePlaceholderApi(): PlaceholderApi {
    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(MoshiConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PlaceholderApi::class.java)
}