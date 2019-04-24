package com.gbizotto.dikoin.repository

import com.gbizotto.dikoin.model.Todo

interface PlaceholderRepository {
    fun findTodo(id: Int)
}