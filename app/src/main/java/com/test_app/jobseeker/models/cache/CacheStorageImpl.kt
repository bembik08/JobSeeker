package com.test_app.jobseeker.models.cache

import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.utils.schedulers.Schedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheStorageImpl @Inject constructor(
    private val db: RoomDB,
    private val schedulers: Schedulers
) : CacheDataSource {
    override fun insert(result: Result): Completable = Completable.fromCallable {
        val roomJobs = Result(
            0,
            Category(0, result.category.label, result.category.tag),
            Company(0, result.company.displayName),
            result.created,
            result.description,
            result.latitude,
            Location(
                0,
                result.location.area,
                result.location.displayLocation
            ),
            result.longitude,
            result.url,
            result.salary,
            result.salaryMax,
            result.salaryMin,
            result.title
        )
        db.jobs.insertJob(roomJobs)
    }.subscribeOn(schedulers.io())

    override fun getAll(): Single<List<com.test_app.jobseeker.models.cache.Result>> =
        db.jobs.getAll().subscribeOn(schedulers.io())

    override fun delete(description: String): Completable = Completable.fromCallable {
     db.jobs.delete(description)
    }.subscribeOn(schedulers.io())
}