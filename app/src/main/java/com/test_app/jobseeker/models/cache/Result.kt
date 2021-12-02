package com.test_app.jobseeker.models.cache

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobs")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val resultId: Int,
    @Embedded
    val category: Category,
    @Embedded
    val company: Company,
    val created: String,
    val description: String,
    val latitude: Double,
    @Embedded
    val location: Location,
    val longitude: Double,
    val url: String,
    val salary: String,
    val salaryMax: Int,
    val salaryMin: Int,
    val title: String
)
