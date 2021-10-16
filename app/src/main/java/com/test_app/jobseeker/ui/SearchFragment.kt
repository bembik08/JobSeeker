package com.test_app.jobseeker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.test_app.jobseeker.R
import com.test_app.jobseeker.databinding.FragmentSearchBinding
import com.test_app.jobseeker.navigation.FavoriteScreen
import com.test_app.jobseeker.presenters.SearchPresenter
import com.test_app.jobseeker.ui.daggerAbs.AbsFragment
import com.test_app.jobseeker.view.SearchView
import kotlinx.android.synthetic.main.activity_main.view.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class SearchFragment : AbsFragment(R.layout.fragment_search), SearchView {
    companion object {
        fun newInstance() = SearchFragment()
    }

    private val viewBinding: FragmentSearchBinding by viewBinding(CreateMethod.INFLATE)

    @Inject
    lateinit var router: Router
    private val presenter by moxyPresenter { SearchPresenter(router) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun showError(msg: String) {
        this.view?.let { Snackbar.make(it, msg, BaseTransientBottomBar.LENGTH_SHORT).show() }
    }

    override fun setMenu() {
        viewBinding.root.rootView.tool_bar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.filter_menu -> presenter.sliderExpanded()
                R.id.favorite_menu -> router.navigateTo(FavoriteScreen.create())
            }
            false
        }
    }

    override fun showFilter() {
        viewBinding.navigationView.animate().x(500f).alpha(100f).interpolator = LinearInterpolator()
    }

    override fun hideFilter() {
        viewBinding.navigationView
            .animate()
            .x(2000f)
            .interpolator = LinearInterpolator()
    }

    override fun setListener() {
        viewBinding.searchBtn.setOnClickListener {
            presenter.searchEvent(viewBinding.searcher.editText?.text.toString())
        }
        viewBinding.navigationView.setNavigationItemSelectedListener {
            presenter.selectedCountry(it.titleCondensed)
            false
        }
    }

}