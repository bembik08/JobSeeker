package com.test_app.jobseeker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.google.android.material.snackbar.Snackbar
import com.test_app.jobseeker.R
import com.test_app.jobseeker.databinding.FragmentViewPagerVacancyBinding
import com.test_app.jobseeker.models.Repo
import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.presenters.VacancyPresenter
import com.test_app.jobseeker.ui.daggerAbs.AbsFragment
import com.test_app.jobseeker.utils.maps.MapView
import com.test_app.jobseeker.utils.schedulers.Schedulers
import com.test_app.jobseeker.view.VacancyView
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class ViewPagerVacancy : AbsFragment(R.layout.fragment_view_pager_vacancy), VacancyView {
    companion object {
        private const val ARG_DUTY = "arg_duty"
        fun newInstance(searchVal: String) = ViewPagerVacancy().apply {
            arguments = bundleOf(ARG_DUTY to searchVal)
        }
    }

    private val searchingVal: String? by lazy {
        arguments?.getString(ARG_DUTY)
    }
    private val viewBinding: FragmentViewPagerVacancyBinding by viewBinding(CreateMethod.INFLATE)

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var map : MapView

    @Inject
    lateinit var repo: Repo

    @Inject
    lateinit var schedulers: Schedulers
    private val presenter by moxyPresenter {
        VacancyPresenter(
            searchingVal,
            repo,
            schedulers
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun showData(data: JobsDTO) {
        viewBinding.viewPager.adapter = ViewPagerAdapter(data, map)
    }

    override fun showError(error: Throwable) {
        error.message?.let { Snackbar.make(viewBinding.root, it, Snackbar.LENGTH_SHORT).show() }
    }

    override fun back() {
        router.exit()
    }
}