package com.example.a04_08projektwoche02.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Quiz::class], version = 1, exportSchema = false)
abstract class QuizDatabase : RoomDatabase() {
    abstract fun dao(): QuizDao

    companion object {
        @Volatile
        private var instance: QuizDatabase? = null

        fun getDatabase(context: Context): QuizDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context, QuizDatabase::class.java, "quizzes_db"
                ).build().also { instance = it }
            }
        }
    }
}
