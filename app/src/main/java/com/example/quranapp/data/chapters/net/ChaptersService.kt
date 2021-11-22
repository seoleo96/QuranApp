package com.example.quranapp.data.chapters.net

import retrofit2.Response
import retrofit2.http.GET


interface ChaptersService {

    @GET("gh/fawazahmed0/quran-api@1/info.json")
    suspend fun fetchQuranChaptersList(): Response<QuranChaptersModel>
}