package com.example.quranapp.data.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.chapters.net.QuranCloudModel
import com.example.quranapp.data.chapters.net.QuranDataMapper

interface QuranCloudMapper : Abstract.Mapper {

    fun map(quranCloudList: List<QuranCloudModel>): List<QuranDataModel>

    class Base(private val quranDataMapper: QuranDataMapper) : QuranCloudMapper {
        override fun map(quranCloudList: List<QuranCloudModel>): List<QuranDataModel> {
            return quranCloudList.map { quranCloudModel ->
                quranCloudModel.map(mapper = quranDataMapper)
            }
        }
    }
}