package com.myc.journeydemo.repository.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by joemiao.
 *
 * Init retrofit client
 */
object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private var retrofit: Retrofit? = null

    val service: ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}