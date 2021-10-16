package com.test_app.jobseeker.view

import com.test_app.jobseeker.models.api.data.JobsDTO
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface VacancyView : MvpView{
    fun showData(data : JobsDTO)
    fun showError(error: Throwable)
    fun back()
}