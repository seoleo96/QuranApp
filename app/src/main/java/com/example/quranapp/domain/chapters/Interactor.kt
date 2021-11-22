package com.example.quranapp.domain.chapters

import com.example.quranapp.data.chapters.net.QuranDomainMapper

interface Interactor {

    suspend fun fetchChaptersList(): QuranDomain

    class Base(
        private val repository: QuranRepository,
        private val quranDomainMapper: QuranDomainMapper,
    ) : Interactor {
        override suspend fun fetchChaptersList(): QuranDomain {
            val listQuranData = repository.fetchQuranChapters()
            return listQuranData.map(quranDomainMapper)
        }
    }
}