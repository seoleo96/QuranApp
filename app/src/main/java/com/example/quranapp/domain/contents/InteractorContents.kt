package com.example.quranapp.domain.contents

import com.example.quranapp.data.contents.net.ContentDomainMapper

interface InteractorContents {

    suspend fun fetchContentsList(): ContentDomain

    class Base(
        private val repository: ContentRepository,
        private val contentDomainMapper: ContentDomainMapper,
    ) : InteractorContents {
        override suspend fun fetchContentsList(): ContentDomain {
            val listContentData = repository.fetchQuranContents()
            return listContentData.map(contentDomainMapper)
        }
    }
}