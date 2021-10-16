package com.test_app.jobseeker.models.cloud

import com.test_app.jobseeker.models.api.data.JobsDTO
import io.reactivex.rxjava3.core.Maybe

interface CloudDataSource {
    fun getJobs( countrySearch: String?,searchValue: String?, page: Int): Maybe<JobsDTO>
}