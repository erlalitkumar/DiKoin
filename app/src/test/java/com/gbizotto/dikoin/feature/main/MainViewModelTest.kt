package com.gbizotto.dikoin.feature.main

import com.gbizotto.dikoin.repository.HelloRepository
import com.gbizotto.dikoin.repository.PlaceholderRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private val helloRepository = mockk<HelloRepository>(relaxed = true)
    private val placeholderRepository = mockk<PlaceholderRepository>(relaxed = true)

    private val viewModel = MainViewModel(helloRepository, placeholderRepository)

    @Before
    fun setup() {
        mockRepositories()
    }

    @Test
    fun whenSayHelloIsPressed_mustSayHello() {
        viewModel.onSayHi()

        assertEquals("Hi hi! from MainViewModel", viewModel.button.get())
    }

    @Test
    fun whenCallApiIsPressed_mustCallApi() {
        viewModel.findMyTodo()

        verify { placeholderRepository.findTodo(1) }
    }

    private fun mockRepositories() {
        every { helloRepository.giveHello() }.returns("Hi hi!")
    }
}