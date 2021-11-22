package com.example.quranapp.data.contents.net

import com.example.quranapp.core.Abstract
import com.example.quranapp.data.contents.ContentDataModel
import com.google.gson.annotations.SerializedName


data class ContentCloudModel(
    @SerializedName("chapter")
    private val id: Int,
    @SerializedName("text")
    private val content: String,
) : Abstract.Object<ContentDataModel, ContentDataMapper>() {
    override fun map(mapper: ContentDataMapper): ContentDataModel {
        return mapper.map(id, content)
    }
}