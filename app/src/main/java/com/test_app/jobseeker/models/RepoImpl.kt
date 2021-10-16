package com.test_app.jobseeker.models

import com.test_app.jobseeker.models.api.data.*
import com.test_app.jobseeker.models.cache.CacheDataSource
import com.test_app.jobseeker.models.cloud.CloudDataSource
import com.test_app.jobseeker.utils.schedulers.Schedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val cloud: CloudDataSource,
    private val cache: CacheDataSource,
    private val schedulers: Schedulers
) : Repo {
    override fun getJobs(
        countrySearch: String?,
        searchVal: String?,
        page: Int
    ): Observable<JobsDTO> = cloud
        .getJobs(countrySearch,searchVal, page)
        .toObservable().subscribeOn(schedulers.io())

    override fun addFav(result: Result): Completable = cache
        .insert(result)
        .subscribeOn(schedulers.io())
    override fun getFavoriteJobs(): Single<List<Result>> = cache.getAll().map { result ->
        result.map {
            Result(
                Category(it.category.label, it.category.tag),
                Company(it.company.displayName),
                it.created,
                it.description,
                it.resultId.toFloat(),
                it.latitude,
                Location(it.location.area, it.location.displayLocation),
                it.longitude,
                it.url,
                it.salary,
                it.salaryMax,
                it.salaryMin,
                it.title
            )
        }
    }.subscribeOn(schedulers.io())

    override fun deleteFromFavorite(description: String) : Completable = cache
        .delete(description)
        .subscribeOn(schedulers.io())
}