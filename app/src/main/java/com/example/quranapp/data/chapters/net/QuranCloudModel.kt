package com.example.quranapp.data.chapters.net

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.chapters.QuranDataModel
import com.google.gson.annotations.SerializedName

data class QuranCloudModel(
    @SerializedName("chapter")
    private val id: Int,
    @SerializedName("name")
    private val name: String
) : Abstract.Object<QuranDataModel, QuranDataMapper>() {
    override fun map(mapper: QuranDataMapper): QuranDataModel {
        return mapper.map(id, name)
    }
}