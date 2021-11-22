package com.example.quranapp.data.contents

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.quranapp.core.Abstract
import com.example.quranapp.domain.contents.ContentDomainModel

@Entity(tableName = "contents")
data class ContentDataModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val content : String
) :  Abstract.Object<ContentDomainModel, ContentDataModelToDomainMapper>(){
    override fun map(mapper: ContentDataModelToDomainMapper): ContentDomainModel {
        return mapper.map(id = id, content = content)
    }
}