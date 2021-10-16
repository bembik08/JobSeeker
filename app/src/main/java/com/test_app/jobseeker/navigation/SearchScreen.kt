package com.test_app.jobseeker.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.test_app.jobseeker.ui.SearchFragment

object SearchScreen {
    fun create(): Screen = FragmentScreen { SearchFragment.newInstance() }
}