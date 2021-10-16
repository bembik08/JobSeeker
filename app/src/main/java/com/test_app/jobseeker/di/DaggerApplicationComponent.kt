package com.test_app.jobseeker.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.test_app.jobseeker.JobSeekerApp
import com.test_app.jobseeker.di.modules.ApiModule
import com.test_app.jobseeker.di.modules.JobSeekerModule
import com.test_app.jobseeker.utils.schedulers.Schedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton
@Singleton
@Component(modules = [AndroidInjectionModule::class, JobSeekerModule::class,
    ApiModule::class])
interface DaggerApplicationComponent: AndroidInjector<JobSeekerApp> {
   @Component.Builder
   interface Builder{
        @BindsInstance
        fun withContext(context: Context): Builder
        @BindsInstance
        fun withRouter(router: Router): Builder
        @BindsInstance
        fun withHolder(navigatorHolder: NavigatorHolder): Builder
        @BindsInstance
        fun withScheduler(schedulers: Schedulers) : Builder
   }
}