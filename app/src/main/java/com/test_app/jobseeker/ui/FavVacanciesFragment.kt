package com.test_app.jobseeker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test_app.jobseeker.databinding.FragmentFavVacanciesBinding

class FavVacanciesFragment : Fragment() {
    private val viewBinding: FragmentFavVacanciesBinding by viewBinding(CreateMethod.INFLATE)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    companion object {
        fun newInstance() = FavVacanciesFragment()
    }
}