package com.test_app.jobseeker

import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.verify
import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.presenters.VacancyPresenter
import com.test_app.jobseeker.view.VacancyView
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class VacancyPresenterTests {
    @Mock
    private lateinit var presenter: VacancyPresenter

    @Mock
    private lateinit var repo: Repo

    private val searchVal = "String"
    private val countrySearch = "String"

    @Mock
    private lateinit var view: VacancyView

    @Mock
    private lateinit var result: Result

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun presenter_OnFirstViewAttachedTest() {
        val scheduler = TestScheduler()
        Mockito.doReturn(Observable.just(Mockito.mock(JobsDTO::class.java))).`when`(
            repo
        ).getJobs(countrySearch, searchVal, 1)

        val testObserver: TestObserver<JobsDTO> = repo
            .getJobs(countrySearch, searchVal, 1)
            .subscribeOn(scheduler)
            .observeOn(scheduler)
            .test()
        presenter.attachView(view)
        verify(repo, atLeastOnce()).getJobs(countrySearch, searchVal, 1)
        testObserver.dispose()
    }

    @Test
    fun presenter_FavoriteVacAddTest() {
        doAnswer {
            repo.addFav(result)
        }.`when`(presenter).addFavoriteVacancy(result)
        presenter.addFavoriteVacancy(result)
        verify(repo, atLeastOnce()).addFav(result)
    }
}