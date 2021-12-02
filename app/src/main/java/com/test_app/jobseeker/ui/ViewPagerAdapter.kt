package com.test_app.jobseeker.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test_app.jobseeker.databinding.ItemVacancyLayoutBinding
import com.test_app.jobseeker.models.api.data.JobsDTO
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.presenters.VacancyPresenter
import com.test_app.jobseeker.utils.maps.MapView
import com.yandex.mapkit.MapKitFactory

class ViewPagerAdapter(
    private var data: JobsDTO,
    private val map: MapView,
    private val presenter: VacancyPresenter,
    private val searchingVal: String?,
    private val countrySearch: String?
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolderVacancy>() {
    private var page = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderVacancy =
        ViewHolderVacancy(
            ItemVacancyLayoutBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        ).apply {
            MapKitFactory.initialize(parent.context)
            MapKitFactory.getInstance().onStart()
        }

    override fun onBindViewHolder(holder: ViewHolderVacancy, position: Int) {
        holder.start()
        holder.setData(data.results, position)
        if (position == data.results.size - 1) {
            presenter.findJob(searchingVal, countrySearch, ++page)
        }
    }

    override fun getItemCount(): Int = data.results.size

    inner class ViewHolderVacancy(
        private val binding: ItemVacancyLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setData(results: List<Result>, position: Int) = with(binding) {
            companyName.text = results[position].company.displayName
            role.text = results[position].title
            text.text = results[position].description
            location.text = results[position].location.displayLocation
            map.showMap(results[position].latitude, results[position].longitude, binding.yandexMap)
            url.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(results[position].url))
                root.context.startActivity(intent)
            }
            binding.btnFavorite.setOnClickListener {
                presenter.addFavoriteVacancy(data.results[position])
            }
        }

        fun start() {
            binding.yandexMap.onStart()
        }
    }
}
