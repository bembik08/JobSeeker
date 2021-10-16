package com.test_app.jobseeker.presenters

import com.test_app.jobseeker.extensions.SUCCESS_DELETE_FROM_FAVORITE_MSG
import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.utils.schedulers.Schedulers
import com.test_app.jobseeker.view.FavVacanciesView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter

class FavVacanciesPresenter(
    private val repo: Repo,
    private val schedulers: Schedulers
) : MvpPresenter<FavVacanciesView>() {
    private val disposable = CompositeDisposable()
    override fun onFirstViewAttach() {
        disposable += repo.getFavoriteJobs().observeOn(schedulers.main()).subscribe(
            {   val data = mutableListOf<Result>()
                data.addAll(it)
                viewState.setData(data)
            },
            viewState::showError
        )
    }

    fun deleteJob(job: Result){
        disposable+= repo.deleteFromFavorite(job.description)
            .observeOn(schedulers.main())
            .subscribe(
                {viewState.showSuccess(SUCCESS_DELETE_FROM_FAVORITE_MSG)},
                viewState::showError
        )
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}