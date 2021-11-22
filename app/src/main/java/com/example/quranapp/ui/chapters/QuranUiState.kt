package com.example.quranapp.ui.chapters

import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.chapters.ErrorType

sealed class QuranUiState : Abstract.Object<Unit, QuranUiState.StringMapper>() {
    override fun map(mapper: StringMapper) = Unit

    object Progress : QuranUiState()

    class Base(
        private val id: Int,
        private val name: String
    ) : QuranUiState(){
        override fun map(mapper: StringMapper) {
            return mapper.map(name, id)
        }
    }

    class Fail(
        private val errorType: ErrorType
    ) : QuranUiState(){
        override fun map(mapper: StringMapper) {
            return mapper.map(text = errorType.toString(), 0)
        }
    }

    interface StringMapper : Abstract.Mapper {
        fun map(text: String, id : Int)
    }

}