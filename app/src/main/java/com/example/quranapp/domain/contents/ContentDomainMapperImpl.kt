package com.example.quranapp.domain.contents

import com.example.quranapp.data.contents.ContentDataModel
import com.example.quranapp.data.contents.ContentDataModelToDomainMapper
import com.example.quranapp.data.contents.net.ContentDomainMapper

class ContentDomainMapperImpl(private val contentDataModelToDomainMapper: ContentDataModelToDomainMapper) :
    ContentDomainMapper {
    override fun map(chaptersList: List<ContentDataModel>): ContentDomain {
        return ContentDomain.Success(chaptersList, contentDataModelToDomainMapper)
    }

    override fun map(exception: Exception): ContentDomain {
        return ContentDomain.Fail(exception = exception)
    }
}