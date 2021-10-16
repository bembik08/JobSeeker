package com.test_app.jobseeker.models

import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.models.api.data.Result
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface Repo {
    fun getJobs(countrySearch: String?, searchVal: String?, page: Int): Observable<JobsDTO>
    fun addFav(result: Result): Completable
    fun getFavoriteJobs(): Single<List<Result>>
    fun deleteFromFavorite(description: String): Completable
}