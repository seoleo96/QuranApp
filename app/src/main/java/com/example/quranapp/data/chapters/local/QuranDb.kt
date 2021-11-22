package com.example.quranapp.data.chapters.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quranapp.data.chapters.QuranDataModel

@Database(entities = [QuranDataModel::class], version = 1, exportSchema = false)
abstract class QuranDb() : RoomDatabase() {

    abstract fun covidDao() : QuranDao
    companion object{
        @Volatile
        private var INSTANCE : QuranDb? = null
        fun getDatabase(context: Context) : QuranDb {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this)  {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuranDb::class.java,
                    "quran_db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}