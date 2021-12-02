package com.test_app.jobseeker.di.modules

import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.RepoImpl
import com.test_app.jobseeker.models.cache.CacheDataSource
import com.test_app.jobseeker.models.cache.CacheStorageImpl
import com.test_app.jobseeker.models.cloud.CloudDataSource
import com.test_app.jobseeker.models.cloud.RetrofitImpl
import com.test_app.jobseeker.ui.FavVacanciesFragment
import com.test_app.jobseeker.ui.MainActivity
import com.test_app.jobseeker.ui.SearchFragment
import com.test_app.jobseeker.ui.ViewPagerVacancy
import com.test_app.jobseeker.utils.maps.MapView
import com.test_app.jobseeker.utils.maps.YandexMap
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface JobSeekerModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    fun bindViewPagerVacancy(): ViewPagerVacancy

    @ContributesAndroidInjector
    fun bindFavVacanciesFragment(): FavVacanciesFragment

    @Binds
    fun bindCloud(retrofit: RetrofitImpl): CloudDataSource

    @Binds
    fun bindRepo(repo: RepoImpl): Repo

    @Binds
    fun bindMap(map: YandexMap): MapView

    @Binds
    fun bindCacheStorage(storage: CacheStorageImpl): CacheDataSource
}