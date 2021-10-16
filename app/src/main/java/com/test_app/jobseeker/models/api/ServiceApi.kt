package com.test_app.jobseeker.models.api

import com.test_app.jobseeker.BuildConfig
import com.test_app.jobseeker.models.api.data.JobsDTO
import io.reactivex.rxjava3.core.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("1/?app_key=${BuildConfig.ADZUNA_APP_KEY}&app_id=${BuildConfig.ADZUNA_APP_ID}")
    fun seekJobs(@Query("what") search: String?): Maybe<JobsDTO>
}