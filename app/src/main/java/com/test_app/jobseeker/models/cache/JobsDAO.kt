package com.test_app.jobseeker.models.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface JobsDAO {
    @Insert
    fun insertJob(job: Result)

    @Query(value = "SELECT * FROM jobs")
    fun getAll(): Single<List<Result>>

    @Query(value = "SELECT * FROM jobs WHERE resultId = :id")
    fun find(id : Int) : Single<Result>

    @Query(value = "DELETE FROM jobs WHERE  description = :description")
    fun delete(description: String)
}