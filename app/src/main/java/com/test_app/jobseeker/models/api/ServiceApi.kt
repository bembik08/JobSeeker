package com.test_app.jobseeker.models.api

import com.test_app.jobseeker.models.api.data.JobsDTO
import io.reactivex.rxjava3.core.Maybe
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {
    @GET("{country}/search/{page}/")
    fun seekJobs(
        @Path("country") country: String?,
        @Path("page") page: Int,
        @Query("what") search: String?
    ): Maybe<JobsDTO>
}


