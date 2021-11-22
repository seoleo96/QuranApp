package com.example.quranapp.domain.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.ui.chapters.QuranUiState

interface QuranUIStateMapper : Abstract.Mapper {

    fun map(id: Int, name: String): QuranUiState
}