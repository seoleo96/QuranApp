package com.example.quranapp.data.chapters

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.chapters.QuranDomainModel

@Entity(tableName = "chapters")
data class QuranDataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
) :  Abstract.Object<QuranDomainModel, QuranDataModelToDomainMapper>(){
    override fun map(mapper: QuranDataModelToDomainMapper): QuranDomainModel {
        return mapper.map(id = id, name = name )
    }
}