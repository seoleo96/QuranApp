package com.example.quranapp.data.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.contents.ContentDomainModel


interface ContentDataModelToDomainMapper : Abstract.Mapper {

    fun map(id: Int, content: String): ContentDomainModel
}