package com.test_app.jobseeker.models.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Int,
    val label: String,
    val tag: String
)
