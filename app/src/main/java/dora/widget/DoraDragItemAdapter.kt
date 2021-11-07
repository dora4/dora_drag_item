package dora.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class DoraDragItemAdapter : RecyclerView.Adapter<DoraDragItemAdapter.ViewHolder>(), IDragInterface {

    var data: MutableList<String> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun addData(data: List<String>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun canDrag(position: Int): Boolean {
        // 设置不能移动的条目
        return position != 0
    }

    override fun canLeftSwipe(position: Int): Boolean {
        return position != 0
    }

    override fun canRightSwipe(position: Int): Boolean {
        return position != 0
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        Collections.swap(data, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemRemove(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.itemView.findViewById<TextView>(android.R.id.text1)
        textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, null))
    }
}