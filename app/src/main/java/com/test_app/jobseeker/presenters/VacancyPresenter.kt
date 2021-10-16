package com.test_app.jobseeker.presenters

import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.utils.schedulers.Schedulers
import com.test_app.jobseeker.view.VacancyView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class VacancyPresenter(
    private val searchVal: String?,
    private val repo: Repo,
    private val schedulers: Schedulers
) : MvpPresenter<VacancyView>() {
    private val dispose = CompositeDisposable()
    override fun onFirstViewAttach() {
        dispose += repo.getJobs(searchVal)
            .observeOn(schedulers.main())
            .subscribe(
                viewState::showData,
                viewState::showError
            )
    }

    override fun onDestroy() {
        dispose.clear()
    }
}