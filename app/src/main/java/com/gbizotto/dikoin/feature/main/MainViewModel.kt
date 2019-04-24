package com.gbizotto.dikoin.feature.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.gbizotto.dikoin.repository.HelloRepository
import com.gbizotto.dikoin.repository.PlaceholderRepository

class MainViewModel (private val repository: HelloRepository,
                     private val placeholderRepository: PlaceholderRepository): ViewModel() {
    val title = "Hello there!"
    val button = ObservableField<String>("Say hi!")
    private fun sayHello() = "${repository.giveHello()} from $this"

    fun onSayHi() {
        button.set(sayHello())
    }

    fun findMyTodo() {
        placeholderRepository.findTodo(1)
    }
}
