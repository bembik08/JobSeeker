package com.test_app.jobseeker.models.cache

import com.test_app.jobseeker.models.api.data.Result
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CacheDataSource {
    fun insert(result: Result): Completable
    fun getAll(): Single<List<com.test_app.jobseeker.models.cache.Result>>
    fun delete(description: String) : Completable
}