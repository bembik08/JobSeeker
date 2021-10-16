package com.test_app.jobseeker.models

import com.test_app.jobseeker.models.api.data.JobsDTO
import io.reactivex.rxjava3.core.Maybe

interface Repo {
    fun getJobs(searchValue: String?) : Maybe<JobsDTO>
}