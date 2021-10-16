package com.test_app.jobseeker.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.test_app.jobseeker.ui.ViewPagerVacancy

object ViewPagerVacancyScreen {
    fun create(searchVal: String): Screen = FragmentScreen {
        ViewPagerVacancy.newInstance(searchVal)
    }
}