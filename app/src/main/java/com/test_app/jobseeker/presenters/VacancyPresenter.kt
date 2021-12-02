package com.test_app.jobseeker.presenters

import android.util.Log
import com.test_app.jobseeker.extensions.SUCCESS_ADD_TO_FAVORITE_MSG
import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.utils.schedulers.Schedulers
import com.test_app.jobseeker.view.VacancyView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class VacancyPresenter(
    private val searchVal: String?,
    private val countrySearch: String?,
    private val repo: Repo,
    private val schedulers: Schedulers
) : MvpPresenter<VacancyView>() {
    private val dispose = CompositeDisposable()
    override fun onFirstViewAttach() {
        findJob(countrySearch, searchVal, page = 1)
    }

    fun findJob(countrySearch: String?, searchVal: String?, page: Int) {
        dispose += repo.getJobs(searchVal, countrySearch, page)
            .observeOn(schedulers.main())
            .subscribe(
                {
                    viewState.hideProgressBar()
                    viewState.showData(it)
                },
                viewState::showError
            )
    }

    fun addFavoriteVacancy(result: Result) {
        dispose += repo.addFav(result).observeOn(schedulers.main())
            .subscribe(
                {
                    viewState.showSuccess(SUCCESS_ADD_TO_FAVORITE_MSG)
                    Log.e("added", result.toString())
                },
                viewState::showError
            )
    }

    override fun onDestroy() {
        dispose.clear()
    }
}