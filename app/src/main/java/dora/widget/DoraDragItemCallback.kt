package dora.widget

import android.graphics.Canvas
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class DoraDragItemCallback(private val adapter: DoraDragItemAdapter) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val canDrag = adapter.canDrag(viewHolder.adapterPosition)
        val canLeftSwipe = adapter.canLeftSwipe(viewHolder.adapterPosition)
        val canRightSwipe = adapter.canRightSwipe(viewHolder.adapterPosition)
        val dragFlags  = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = (if(canLeftSwipe) ItemTouchHelper.START else 0) or
                (if(canRightSwipe) ItemTouchHelper.END else 0)
        return makeMovementFlags(if (canDrag) dragFlags else 0, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun getMoveThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0f
    }

    override fun canDropOver(recyclerView: RecyclerView, current: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        if (target.adapterPosition == 0) {
            return false
        }
        return super.canDropOver(recyclerView, current, target)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onItemRemove(viewHolder.adapterPosition)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        if (isCurrentlyActive) {
            if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                onDragStart(viewHolder)
            }
        } else {
            onDragEnd(viewHolder)
        }
    }

    private fun onDragStart(viewHolder: RecyclerView.ViewHolder) {
        val textView = viewHolder.itemView.findViewById<TextView>(android.R.id.text1)
        // 放大20%
        textView.scaleX = 1.2f
        textView.scaleY = 1.2f
    }

    private fun onDragEnd(viewHolder: RecyclerView.ViewHolder) {
        val textView = viewHolder.itemView.findViewById<TextView>(android.R.id.text1)
        // 还原
        textView.scaleX = 1f
        textView.scaleY = 1f
    }
}