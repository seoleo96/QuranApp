package com.example.quranapp.data.chapters

import com.example.quranapp.data.chapters.local.QuranCacheDataSource
import com.example.quranapp.data.chapters.net.QuranCloudDataSource
import com.example.quranapp.data.chapters.net.QuranCloudModel
import com.example.quranapp.domain.chapters.QuranRepository

class QuranRepositoryImpl(
    private val cloudDataSource: QuranCloudDataSource,
    private val cloudMapper: QuranCloudMapper,
    private val cacheDataSource: QuranCacheDataSource,
) : QuranRepository {

    override suspend fun fetchQuranChapters(): QuranData {
        return try {
            val cacheChapters: List<QuranDataModel> = cacheDataSource.fetchChapters()
            if (cacheChapters.isEmpty()) {
                val quranCloudList: List<QuranCloudModel> =
                    cloudDataSource.fetchQuranChaptersList()
                val quran: List<QuranDataModel> = cloudMapper.map(quranCloudList)
                cacheDataSource.insertChapters(chapters = quran)
                QuranData.Success(chaptersList = quran)
            } else {
                QuranData.Success(chaptersList = cacheChapters)
            }
        } catch (e: Exception) {
            QuranData.Fail(e)
        }
    }
}