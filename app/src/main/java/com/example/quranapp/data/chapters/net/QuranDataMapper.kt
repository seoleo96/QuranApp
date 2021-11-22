package com.example.quranapp.data.chapters.net

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.chapters.QuranDataModel

interface QuranDataMapper : Abstract.Mapper {

    fun map(id: Int, name: String): QuranDataModel

    class Base : QuranDataMapper {
        override fun map(id: Int, name: String) = QuranDataModel(id = id, name = name)
    }
}