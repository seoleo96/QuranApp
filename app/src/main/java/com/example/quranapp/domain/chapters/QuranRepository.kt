package com.example.quranapp.domain.chapters

import com.example.quranapp.data.chapters.QuranData

interface QuranRepository {

    suspend fun fetchQuranChapters() : QuranData

}