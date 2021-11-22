package com.example.quranapp.data.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.chapters.QuranDomainModel

interface QuranDataModelToDomainMapper : Abstract.Mapper {

    fun map(id: Int, name: String): QuranDomainModel
}