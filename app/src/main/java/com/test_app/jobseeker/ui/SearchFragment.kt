package com.test_app.jobseeker.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.test_app.jobseeker.R
import com.test_app.jobseeker.databinding.FragmentSearchBinding
import com.test_app.jobseeker.presenters.SearchPresenter
import com.test_app.jobseeker.ui.daggerAbs.AbsFragment
import com.test_app.jobseeker.view.SearchView
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

    override fun setListener() {
        viewBinding.searchBtn.setOnClickListener {
            Log.e("text", viewBinding.searcher.editText?.text.toString())
            presenter.searchEvent(viewBinding.searcher.editText?.text.toString())
        }
    }


}