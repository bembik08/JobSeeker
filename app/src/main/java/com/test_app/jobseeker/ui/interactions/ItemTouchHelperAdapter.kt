package com.test_app.jobseeker.ui.interactions

interface ItemTouchHelperAdapter {
   fun onItemMove(fromPosition: Int, toPosition : Int)
   fun onItemDismiss(position: Int)
}