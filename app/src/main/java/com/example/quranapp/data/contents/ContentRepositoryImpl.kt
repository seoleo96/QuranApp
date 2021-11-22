package com.example.quranapp.data.contents

import com.example.quranapp.data.contents.net.ContentCloudDataSource
import com.example.quranapp.data.contents.net.ContentCloudModel
import com.example.quranapp.domain.contents.ContentRepository

class ContentRepositoryImpl(
    private val cloudDataSource: ContentCloudDataSource,
    private val cloudMapper: ContentCloudMapper,
) : ContentRepository {

    override suspend fun fetchQuranContents(): ContentData {
        return try {
            val contentsCloudList: List<ContentCloudModel> =
                cloudDataSource.fetchQuranChaptersList()
            val content: List<ContentDataModel> = cloudMapper.map(contentsCloudList)
            ContentData.Success(chaptersList = content)

        } catch (e: Exception) {
            ContentData.Fail(e)
        }
    }
}