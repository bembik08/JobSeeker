package com.test_app.jobseeker.di.modules

import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.RepoImpl
import com.test_app.jobseeker.ui.MainActivity
import com.test_app.jobseeker.ui.SearchFragment
import com.test_app.jobseeker.ui.ViewPagerVacancy
import com.test_app.jobseeker.utils.maps.MapView
import com.test_app.jobseeker.utils.maps.YandexMap
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
interface JobSeekerModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector
    fun bindSearchFragment(): SearchFragment
    @ContributesAndroidInjector
    fun bindViewPagerVacancy(): ViewPagerVacancy

    @Singleton
    @Binds
    fun bindRepo(repo : RepoImpl): Repo

    @Singleton
    @Binds
    fun bindMap(map : YandexMap): MapView
}