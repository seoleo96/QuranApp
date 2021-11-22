package com.example.quranapp.domain.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.ui.chapters.QuranUiState
import com.example.quranapp.ui.contents.ContentUiState


data class ContentDomainModel(
    private val id: Int,
    private val name: String,
) : Abstract.Object<ContentUiState, ContentUIStateMapper>() {
    override fun map(mapper: ContentUIStateMapper): ContentUiState {
        return mapper.map(id = id, name = name)
    }
}