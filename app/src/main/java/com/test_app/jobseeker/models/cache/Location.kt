package com.test_app.jobseeker.models.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class Location(
    @PrimaryKey(autoGenerate = true)
    val locationId: Int,
    @TypeConverters(AreaConverter::class)
    val area: List<String>,
    val displayLocation: String
)
