package com.example.quranapp.domain.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.chapters.ErrorType
import com.example.quranapp.ui.contents.ContentUI

interface ContentUiMapper : Abstract.Mapper {

    fun map(chaptersList: List<ContentDomainModel>): ContentUI
    fun map(errorType: ErrorType): ContentUI
}