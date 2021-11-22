package com.example.quranapp.data.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.chapters.net.QuranCloudModel
import com.example.quranapp.data.chapters.net.QuranDataMapper
import com.example.quranapp.data.contents.net.ContentCloudModel
import com.example.quranapp.data.contents.net.ContentDataMapper

interface ContentCloudMapper : Abstract.Mapper {

    fun map(contentCloudList: List<ContentCloudModel>): List<ContentDataModel>

    class Base(private val contentDataMapper: ContentDataMapper) : ContentCloudMapper {
        override fun map(contentCloudList: List<ContentCloudModel>): List<ContentDataModel> {
            return contentCloudList.map { contentCloudModel ->
                contentCloudModel.map(mapper = contentDataMapper)
            }
        }
    }
}