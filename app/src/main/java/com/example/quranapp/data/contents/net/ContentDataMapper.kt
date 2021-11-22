package com.example.quranapp.data.contents.net

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.contents.ContentDataModel


interface ContentDataMapper : Abstract.Mapper {

    fun map(id: Int, name: String): ContentDataModel

    class Base : ContentDataMapper {
        override fun map(id: Int, content: String) = ContentDataModel(id = id, content = content)
    }
}