package com.example.quranapp.ui.contents

import com.example.quranapp.domain.contents.ContentUIStateMapper


class ContentUIStateMapperImpl : ContentUIStateMapper {

    override fun map(id: Int, name: String): ContentUiState {
        return ContentUiState.Base(id, name)
    }
}