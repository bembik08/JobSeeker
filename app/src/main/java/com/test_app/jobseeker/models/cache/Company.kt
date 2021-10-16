package com.test_app.jobseeker.models.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Company(
    @PrimaryKey(autoGenerate = true)
    val companyId: Int,
    val displayName: String
)