package com.test_app.jobseeker.models.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Result::class, Category::class, Company::class, Location::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(AreaConverter::class)
abstract class RoomDB : RoomDatabase() {
    abstract val jobs: JobsDAO
}