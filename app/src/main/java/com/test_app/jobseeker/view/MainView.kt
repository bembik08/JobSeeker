package com.test_app.jobseeker.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView : MvpView {
    fun setBackButtonListener()
}