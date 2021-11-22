package com.example.quranapp.domain.contents

import com.example.quranapp.data.contents.ContentData

interface ContentRepository {

    suspend fun fetchQuranContents(): ContentData

}