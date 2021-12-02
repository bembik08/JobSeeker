package com.test_app.jobseeker.di.modules

import com.google.gson.GsonBuilder
import com.test_app.jobseeker.extensions.ADZUNA_URL
import com.test_app.jobseeker.models.api.ServiceApi
import com.test_app.jobseeker.models.api.interceptors.RequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    @Provides
    fun provideFindWorkApi(): ServiceApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(OkHttpClient()
            .newBuilder().addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).addInterceptor(RequestInterceptor)
            .build()
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ServiceApi::class.java)

    private val gson = GsonBuilder().create()
    private val baseUrl = ADZUNA_URL
}