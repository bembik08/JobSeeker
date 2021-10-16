package com.test_app.jobseeker.presenters

import com.github.terrakok.cicerone.Router
import com.test_app.jobseeker.navigation.SearchScreen
import com.test_app.jobseeker.view.MainView
import moxy.MvpPresenter

class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        router.navigateTo(SearchScreen.create())
        viewState.setBackButtonListener()
    }

    fun onBackButtonPressed() {
        router.navigateTo(SearchScreen.create())
    }

}