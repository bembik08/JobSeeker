package com.test_app.jobseeker.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.test_app.jobseeker.ui.FavVacanciesFragment

object FavoriteScreen {
    fun create(): Screen = FragmentScreen { FavVacanciesFragment.newInstance() }
}