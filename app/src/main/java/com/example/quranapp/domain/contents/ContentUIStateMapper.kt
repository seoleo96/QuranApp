package com.example.quranapp.domain.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.ui.contents.ContentUiState

interface ContentUIStateMapper : Abstract.Mapper {

    fun map(id: Int, name: String): ContentUiState
}