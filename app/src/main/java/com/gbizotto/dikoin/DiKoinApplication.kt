package com.gbizotto.dikoin

import android.app.Application
import com.gbizotto.dikoin.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DiKoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DiKoinApplication)
            modules(appModule)
        }
    }
}