package com.example.quranapp.data.chapters.local

import com.example.quranapp.data.chapters.QuranDataModel

interface QuranCacheDataSource {

    suspend fun fetchChapters() : List<QuranDataModel>
    suspend fun insertChapters(chapters : List<QuranDataModel>)
    suspend fun deleteChapters()

    class Base(
        private val quranDao : QuranDao
    ) : QuranCacheDataSource {
        override suspend fun fetchChapters() : List<QuranDataModel> {
            return quranDao.fetchChapters()
        }

        override suspend fun insertChapters(chapters : List<QuranDataModel>) {
            quranDao.insertAll(chapters)
        }

        override suspend fun deleteChapters() {
            quranDao.deleteAll()
        }
    }
}