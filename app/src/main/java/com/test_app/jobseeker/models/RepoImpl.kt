package com.test_app.jobseeker.models

import com.test_app.jobseeker.models.api.ServiceApi
import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.utils.schedulers.Schedulers
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val api: ServiceApi,
    private val schedulers: Schedulers
) : Repo {
    override fun getJobs(searchValue: String?): Maybe<JobsDTO> =
        api.seekJobs(searchValue)
            .subscribeOn(schedulers.io())

}