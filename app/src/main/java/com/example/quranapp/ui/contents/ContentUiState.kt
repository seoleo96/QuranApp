package com.example.quranapp.ui.contents

import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.chapters.ErrorType

sealed class ContentUiState : Abstract.Object<Unit, ContentUiState.StringMapper>() {
    override fun map(mapper: StringMapper) = Unit

    object Progress : ContentUiState()

    class Base(
        private val id: Int,
        private val name: String,
    ) : ContentUiState() {
        override fun map(mapper: StringMapper) {
            return mapper.map(name, id)
        }
    }

    class Fail(
        private val errorType: ErrorType,
    ) : ContentUiState() {
        override fun map(mapper: StringMapper) {
            return mapper.map(text = errorType.toString(), id = 0)
        }
    }

    interface StringMapper : Abstract.Mapper {
        fun map(text: String, id: Int)
    }

}