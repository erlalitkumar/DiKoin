package com.gbizotto.dikoin.repository

import com.gbizotto.dikoin.model.Todo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceholderApi {
    @GET("todos/{id}")
    fun findTodo(@Path("id") id: Int) : Call<Todo>
}