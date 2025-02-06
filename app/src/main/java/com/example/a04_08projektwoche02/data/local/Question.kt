package com.example.a04_08projektwoche02.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity(tableName = "quizzes")
@TypeConverters(Converters::class)
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val quizID: Int = 0,
    val question: List<String> = listOf() //List not possible -> conversion
)

class Converters {
    @TypeConverter
    fun fromListToString(value: List<String>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun fromStringToList(value: String): List<String>{
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }
}

// Code from: https://stackoverflow.com/a/45071364

//public class Converters {
//    @TypeConverter
//    public static ArrayList<String> fromString(String value) {
//        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
//        return new Gson().fromJson(value, listType);
//    }
//
//    @TypeConverter
//    public static String fromArrayList(ArrayList<String> list) {
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        return json;
//    }
//}