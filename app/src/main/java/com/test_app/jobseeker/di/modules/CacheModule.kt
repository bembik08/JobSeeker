package com.test_app.jobseeker.di.modules

import android.content.Context
import androidx.room.Room
import com.test_app.jobseeker.models.cache.RoomDB
import dagger.Module
import dagger.Provides

@Module
class CacheModule {
    @Provides
    fun provideCache(context: Context): RoomDB = Room.databaseBuilder(
        context,
        RoomDB::class.java,
        "jobSeeker.db"
    )
        .fallbackToDestructiveMigration()
        .build()
}