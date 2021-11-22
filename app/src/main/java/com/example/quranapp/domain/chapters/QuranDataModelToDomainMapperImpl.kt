package com.example.quranapp.domain.chapters

import com.example.quranapp.data.chapters.QuranDataModelToDomainMapper

class QuranDataModelToDomainMapperImpl : QuranDataModelToDomainMapper {

    override fun map(id: Int, name: String): QuranDomainModel {
        return QuranDomainModel(id = id, name = name)
    }
}