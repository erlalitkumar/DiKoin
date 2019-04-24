package com.gbizotto.dikoin.feature.main.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.gbizotto.dikoin.repository.HelloRepository

class MainViewModel (private val repository: HelloRepository): ViewModel() {
    val title = "Hello there!"
    val button = ObservableField<String>("Say hi!")
    private fun sayHello() = "${repository.giveHello()} from $this"

    fun onSayHi() {
        button.set(sayHello())

    }
}
