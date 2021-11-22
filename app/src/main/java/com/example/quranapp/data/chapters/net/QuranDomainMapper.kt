package com.example.quranapp.data.chapters.net

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.chapters.QuranDataModel
import com.example.quranapp.domain.chapters.QuranDomain


interface QuranDomainMapper : Abstract.Mapper {

    fun map(chaptersList: List<QuranDataModel>) : QuranDomain
    fun map(exception: Exception) : QuranDomain
}