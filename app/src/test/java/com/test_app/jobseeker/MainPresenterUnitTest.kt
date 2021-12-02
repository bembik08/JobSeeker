package com.test_app.jobseeker

import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.anyVararg
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.verify
import com.test_app.jobseeker.presenters.MainPresenter
import com.test_app.jobseeker.view.MainView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainPresenterUnitTest {
    private lateinit var mainPresenter: MainPresenter;

    @Mock
    private lateinit var router: Router

    @Mock
    private lateinit var view: MainView

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mainPresenter = MainPresenter(router)
    }

    @Test
    fun presenter_OnBackButtonPressedTest() {
        mainPresenter.onBackButtonPressed()
        verify(router, atLeastOnce()).navigateTo(anyVararg())
    }

    @Test
    fun presenter_OnFirstViewAttachedTest() {
        mainPresenter.attachView(view)
        verify(router, atLeastOnce()).navigateTo(anyVararg())
        verify(view, atLeastOnce()).setBackButtonListener()
    }
}