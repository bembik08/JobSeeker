package com.test_app.jobseeker.presenters

import com.github.terrakok.cicerone.Router
import com.test_app.jobseeker.extensions.DEFAULT_COUNTRY_QUERY
import com.test_app.jobseeker.extensions.EMPTY_FIELD_ERROR_MSG
import com.test_app.jobseeker.navigation.ViewPagerVacancyScreen
import com.test_app.jobseeker.view.SearchView
import moxy.MvpPresenter

class SearchPresenter(private val router: Router) : MvpPresenter<SearchView>() {
    private var isExpandedFilter = false
    private var countrySearch: String? = null
    fun searchEvent(searchVal: String?) {
        if (!searchVal.isNullOrBlank()) {
            if (countrySearch.isNullOrBlank()) {
                countrySearch = DEFAULT_COUNTRY_QUERY
            }
            router.navigateTo(
                ViewPagerVacancyScreen.create(
                    searchVal,
                    countrySearch
                )
            )
        } else {
            viewState.showError(EMPTY_FIELD_ERROR_MSG)
            viewState.setListener()
        }
    }

    override fun onFirstViewAttach() {
        viewState.setListener()
        viewState.setMenu()
    }

    fun sliderExpanded() {
        isExpandedFilter = !isExpandedFilter
        if (isExpandedFilter) {
            viewState.showFilter()
        } else {
            viewState.hideFilter()
        }
    }

    fun selectedCountry(country: CharSequence?) {
        countrySearch = country.toString()
        viewState.hideFilter()
    }
}