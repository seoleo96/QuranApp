package com.example.quranapp.domain.contents

import com.example.quranapp.data.contents.ContentDataModelToDomainMapper

class ContentDataModelToDomainMapperImpl : ContentDataModelToDomainMapper {

    override fun map(id: Int, content: String): ContentDomainModel {
        return ContentDomainModel(id = id, name = content)
    }
}