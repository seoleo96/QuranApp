package com.example.quranapp.domain.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.contents.ContentDataModel
import com.example.quranapp.data.contents.ContentDataModelToDomainMapper
import com.example.quranapp.domain.chapters.ErrorType
import com.example.quranapp.ui.contents.ContentUI
import retrofit2.HttpException
import java.net.UnknownHostException


sealed class ContentDomain : Abstract.Object<ContentUI, ContentUiMapper>() {
    class Success(
        private val contentsList: List<ContentDataModel>,
        private val contentMapper: ContentDataModelToDomainMapper,
    ) : ContentDomain() {
        override fun map(mapper: ContentUiMapper): ContentUI {
            return mapper.map(chaptersList = contentsList.map { contentModel ->
                contentModel.map(contentMapper)
            })
        }
    }

    class Fail(private val exception: Exception) : ContentDomain() {
        override fun map(mapper: ContentUiMapper): ContentUI {
            return mapper.map(
                when (exception) {
                    is UnknownHostException -> ErrorType.NO_CONNECTION
                    is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                    else -> ErrorType.GENERIC_ERROR
                }
            )
        }
    }
}