package com.test_app.jobseeker.models.api.interceptors

import com.test_app.jobseeker.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val urlReqParams = request
            .url
            .newBuilder()
            .addEncodedQueryParameter("app_key", BuildConfig.ADZUNA_APP_KEY)
            .setEncodedQueryParameter("app_id", BuildConfig.ADZUNA_APP_ID)
            .build()
        val req = request
            .newBuilder()
            .url(urlReqParams)
            .build()
        return chain.proceed(req)
    }
}