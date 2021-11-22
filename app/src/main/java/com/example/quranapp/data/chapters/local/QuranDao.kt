package com.example.quranapp.data.chapters.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quranapp.data.chapters.QuranDataModel

@Dao
interface QuranDao {

    @Query("SELECT * FROM chapters ORDER BY id ASC")
    suspend fun fetchChapters(): List<QuranDataModel>
//
//    @Query("SELECT * FROM covid_countries WHERE country LIKE '%'|| :searchCountry ||'%' ORDER BY country ASC")
//    fun searchCountries(searchCountry : String): Flow<List<Country>>

    @Query("DELETE FROM chapters")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(chapters: List<QuranDataModel>)
}