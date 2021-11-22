package com.example.quranapp.data.contents.net

interface ContentCloudDataSource {

    suspend fun fetchQuranChaptersList(): List<ContentCloudModel>

    class Base(private val contentsService: ContentsService) : ContentCloudDataSource {
        override suspend fun fetchQuranChaptersList(): List<ContentCloudModel> =
            contentsService.fetchChapters().body()!!.quran
    }
}