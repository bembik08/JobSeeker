package com.test_app.jobseeker.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test_app.jobseeker.databinding.ItemFavoriteVacancyBinding
import com.test_app.jobseeker.models.api.data.Result
import com.test_app.jobseeker.presenters.FavVacanciesPresenter
import com.test_app.jobseeker.ui.interactions.ItemTouchHelperAdapter
import com.test_app.jobseeker.ui.interactions.ItemTouchViewHolder
import com.test_app.jobseeker.ui.interactions.OnStartDragListener

class AdapterFavVacancies(
    private val data: MutableList<Result>,
    private val presenter: FavVacanciesPresenter,
    private val onStartDragListener: OnStartDragListener,
) : RecyclerView.Adapter<AdapterFavVacancies.ItemFavVacancies>(), ItemTouchHelperAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFavVacancies =
        ItemFavVacancies(
            ItemFavoriteVacancyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemFavVacancies, position: Int) {
        holder.setData(position)
    }

    override fun getItemCount(): Int = data.size

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        data.removeAt(fromPosition).apply {
            data.add(
                if (toPosition < fromPosition && toPosition != 0) toPosition - 1 else toPosition,
                this
            )
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        presenter.deleteJob(data[position])
        data.removeAt(position)
        notifyItemRemoved(position)
    }


    inner class ItemFavVacancies(
        private val binding: ItemFavoriteVacancyBinding
    ) : RecyclerView.ViewHolder(binding.root), ItemTouchViewHolder {
        @SuppressLint("ClickableViewAccessibility")
        fun setData(position: Int) = with(binding) {
            companyName.text = data[position].company.displayName
            role.text = data[position].title
            text.text = data[position].description
            location.text = data[position].location.displayLocation
            deleteBtn.setOnClickListener {
                presenter.deleteJob(data[position])
                data.removeAt(position)
                notifyItemRemoved(position)
            }
            container.setOnTouchListener { _, motionEvent ->
                if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                    onStartDragListener.onStartDrag(this@ItemFavVacancies)
                }
                false
            }
            urlBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data[position].url))
                root.context.startActivity(intent)
            }
        }

        override fun onItemSelected() {
            itemView.setBackgroundColor(Color.GRAY)
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(Color.WHITE)
        }
    }
}