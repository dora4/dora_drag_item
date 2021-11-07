package dora.widget

interface IDragInterface {

    fun canDrag(position: Int) : Boolean

    fun canLeftSwipe(position: Int) : Boolean

    fun canRightSwipe(position: Int) : Boolean

    fun onItemMove(fromPosition: Int, toPosition: Int)

    fun onItemRemove(position: Int)
}