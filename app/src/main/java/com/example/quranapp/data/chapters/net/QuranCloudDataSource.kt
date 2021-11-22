package com.example.quranapp.data.chapters.net

interface QuranCloudDataSource {

    suspend fun fetchQuranChaptersList(): List<QuranCloudModel>

    class Base(private val chaptersService: ChaptersService) : QuranCloudDataSource {
        override suspend fun fetchQuranChaptersList(): List<QuranCloudModel> =
            chaptersService.fetchQuranChaptersList().body()!!.chapters
    }
}