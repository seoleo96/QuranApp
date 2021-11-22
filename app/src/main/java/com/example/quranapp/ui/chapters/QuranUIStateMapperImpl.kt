package com.example.quranapp.ui.chapters

import com.example.quranapp.domain.chapters.QuranUIStateMapper

class QuranUIStateMapperImpl : QuranUIStateMapper {

    override fun map(id: Int, name: String): QuranUiState {
        return QuranUiState.Base(id, name)
    }
}