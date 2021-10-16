package com.test_app.jobseeker.presenters

import com.github.terrakok.cicerone.Router
import com.test_app.jobseeker.navigation.ViewPagerVacancyScreen
import com.test_app.jobseeker.view.SearchView
import moxy.MvpPresenter

class SearchPresenter(private val router: Router) : MvpPresenter<SearchView>() {
    fun searchEvent(searchVal: String?) {
        if (!searchVal.isNullOrBlank()) {
            router.navigateTo(ViewPagerVacancyScreen.create(searchVal))
        } else {
            viewState.showError("Empty String")
            viewState.setListener()
        }
    }
    override fun onFirstViewAttach() {
        viewState.setListener()
    }
}