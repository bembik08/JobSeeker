package com.test_app.jobseeker.di.modules

import com.google.gson.GsonBuilder
import com.test_app.jobseeker.models.api.ServiceApi
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
    fun provideBaseUrl(): String = "https://api.adzuna.com/v1/api/jobs/ru/search/"

    @Provides
    fun provideFindWorkApi(baseUrl: String): ServiceApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                val request = chain.request()
                request.newBuilder()
                    .build()
                chain.proceed(request)
            }.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ServiceApi::class.java)

    private val gson = GsonBuilder().create()


}