package com.example.quranapp.data.contents.net

import retrofit2.Response
import retrofit2.http.GET

interface ContentsService {

    @GET("gh/fawazahmed0/quran-api@1/editions/uzb-muhammadsodikmu.json")
    suspend fun fetchChapters() : Response<QuranContentsModel>
}