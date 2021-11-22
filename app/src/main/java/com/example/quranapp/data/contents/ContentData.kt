package com.example.quranapp.data.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.contents.net.ContentDomainMapper
import com.example.quranapp.domain.contents.ContentDomain

sealed class ContentData : Abstract.Object<ContentDomain, ContentDomainMapper>() {
    class Success(private val chaptersList: List<ContentDataModel>) : ContentData() {
        override fun map(mapper: ContentDomainMapper): ContentDomain {
            return mapper.map(chaptersList = chaptersList)
        }

    }

    class Fail(private val e: Exception) : ContentData() {
        override fun map(mapper: ContentDomainMapper): ContentDomain {
            return mapper.map(exception = e)
        }
    }
}
