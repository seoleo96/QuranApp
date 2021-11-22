package com.example.quranapp.domain.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.chapters.QuranDataModel
import com.example.quranapp.data.chapters.QuranDataModelToDomainMapper
import com.example.quranapp.ui.chapters.QuranUI
import retrofit2.HttpException
import java.net.UnknownHostException


sealed class QuranDomain : Abstract.Object<QuranUI, QuranUiMapper>() {
    class Success(
        private val chaptersList: List<QuranDataModel>,
        private val quranMapper: QuranDataModelToDomainMapper,
    ) : QuranDomain() {
        override fun map(mapper: QuranUiMapper): QuranUI {
            return mapper.map(chaptersList = chaptersList.map { quranDataModel ->
                quranDataModel.map(quranMapper)
            })
        }
    }

    class Fail(private val exception: Exception) : QuranDomain() {
        override fun map(mapper: QuranUiMapper): QuranUI {
            return mapper.map(
                when(exception){
                    is UnknownHostException -> ErrorType.NO_CONNECTION
                    is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                    else -> ErrorType.GENERIC_ERROR
                }
            )
        }
    }
}