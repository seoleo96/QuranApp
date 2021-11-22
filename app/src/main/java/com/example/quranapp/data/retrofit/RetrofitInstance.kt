package com.example.quranapp.data.retrofit

import com.example.quranapp.data.chapters.net.ChaptersService
import com.example.quranapp.data.contents.net.ContentsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    private companion object {
        const val BASE_URL = "https://cdn.jsdelivr.net/"
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val service: ChaptersService = retrofit.create(ChaptersService::class.java)
    val contentService: ContentsService = retrofit.create(ContentsService::class.java)
}