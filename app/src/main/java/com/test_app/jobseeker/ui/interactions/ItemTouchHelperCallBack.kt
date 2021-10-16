package com.test_app.jobseeker.ui.interactions

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.test_app.jobseeker.ui.AdapterFavVacancies

class ItemTouchHelperCallBack(
    private val adapter: AdapterFavVacancies?
) : ItemTouchHelper.Callback() {
    override fun isLongPressDragEnabled(): Boolean  = true
    override fun isItemViewSwipeEnabled(): Boolean  = true

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlag = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlag)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        source: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter?.onItemMove(source.absoluteAdapterPosition, target.absoluteAdapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction != ItemTouchHelper.ACTION_STATE_IDLE){
            val itemViewHolder = viewHolder as ItemTouchViewHolder
             itemViewHolder.onItemSelected()
        }
        super.onSelectedChanged(viewHolder, direction)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        val itemViewHolder = viewHolder as ItemTouchViewHolder
        itemViewHolder.onItemClear()
    }
}