package com.example.quranapp.data.contents.net

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.contents.ContentDataModel
import com.example.quranapp.domain.contents.ContentDomain


interface ContentDomainMapper : Abstract.Mapper {

    fun map(chaptersList: List<ContentDataModel>): ContentDomain
    fun map(exception: Exception): ContentDomain
}