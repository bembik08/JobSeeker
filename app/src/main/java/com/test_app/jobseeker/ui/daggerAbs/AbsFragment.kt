package com.test_app.jobseeker.ui.daggerAbs

import android.content.Context
import androidx.annotation.LayoutRes
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import javax.inject.Inject

abstract class AbsFragment(@LayoutRes layout: Int = 0) : MvpAppCompatFragment(layout),
    HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}