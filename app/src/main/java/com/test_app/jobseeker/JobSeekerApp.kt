package com.test_app.jobseeker

import com.github.terrakok.cicerone.Cicerone
import com.test_app.jobseeker.di.DaggerApplicationComponent
import com.test_app.jobseeker.utils.schedulers.DefaultSchedulers
import com.yandex.mapkit.MapKitFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class JobSeekerApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<JobSeekerApp> =
        DaggerApplicationComponent.builder()
            .withContext(applicationContext).apply {
                val cicerone = Cicerone.create()
                withHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withScheduler(DefaultSchedulers())
            }.build()

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(BuildConfig.YANDEX_MAP_API_KEY)
    }
}