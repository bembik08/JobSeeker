package com.test_app.jobseeker.models.cache

import androidx.room.TypeConverter

class AreaConverter {
    @TypeConverter
    fun fromArea(area: List<String>): String {
        var str = ""
        area.map {
            str = " $it,"
        }
        return str
    }

    @TypeConverter
    fun toArea(area: String): List<String> {
        val list = mutableListOf<String>()
        list.addAll(area.split(","))
        return list
    }
}