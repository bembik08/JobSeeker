package com.test_app.jobseeker

import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.anyVararg
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.verify
import com.test_app.jobseeker.presenters.SearchPresenter
import com.test_app.jobseeker.view.SearchView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SearchPresenterUnitTests {
    private lateinit var presenter: SearchPresenter

    @Mock
    private lateinit var router: Router

    @Mock
    private lateinit var view: SearchView

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        presenter = SearchPresenter((router))
    }

    @Test
    fun searchPresenter_OnFirstViewAttached() {
        presenter.attachView(view)
        verify(view, atLeastOnce()).setListener()
        verify(view, atLeastOnce()).setMenu()
    }

    @Test
    fun searchEvent_Empty() {
        presenter.attachView(view)
        presenter.searchEvent(null)
        verify(view, atLeastOnce()).showError(Mockito.anyString())
        verify(view, atLeastOnce()).setListener()
    }

    @Test
    fun searchEvent_Blank() {
        presenter.attachView(view)
        presenter.searchEvent("")
        verify(view, atLeastOnce()).showError(Mockito.anyString())
        verify(view, atLeastOnce()).setListener()
    }

    @Test
    fun searchEvent_Success() {
        presenter.attachView(view)
        presenter.searchEvent("String")
        verify(router, atLeastOnce()).navigateTo(anyVararg())
    }
    @Test
    fun sliderExpanded_False() {
        presenter.attachView(view)
        presenter.sliderExpanded()
        verify(view, atLeastOnce()).showFilter()
    }
}