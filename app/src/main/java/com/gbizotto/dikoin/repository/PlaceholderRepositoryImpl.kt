package com.gbizotto.dikoin.repository

import android.util.Log
import com.gbizotto.dikoin.model.Todo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceholderRepositoryImpl (private val api: PlaceholderApi): PlaceholderRepository {
    override fun findTodo(id: Int) {
        api.findTodo(id)
            .enqueue(object:Callback<Todo>{
                override fun onFailure(call: Call<Todo>, t: Throwable) {
                    Log.e(" Erro", t.localizedMessage, t)
                }

                override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                    Log.v("Sucesso!", "Todo = ${response.body()}")
                }
            })
    }
}