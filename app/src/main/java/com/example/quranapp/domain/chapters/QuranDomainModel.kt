package com.example.quranapp.domain.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.ui.chapters.QuranUiState


data class QuranDomainModel(
    private val id: Int,
    private val name: String,
) : Abstract.Object<QuranUiState, QuranUIStateMapper>() {
    override fun map(mapper: QuranUIStateMapper): QuranUiState {
        return mapper.map(id = id, name = name)
    }
}