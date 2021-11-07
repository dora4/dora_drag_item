package dora.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = DoraDragItemAdapter()
        val touchHelper = ItemTouchHelper(DoraDragItemCallback(adapter))
        touchHelper.attachToRecyclerView(recyclerView)
        adapter.addData(arrayListOf("基础模块",
                "扩展模块1",
                "扩展模块2",
                "扩展模块3",
                "扩展模块4",
                "扩展模块5",
                "扩展模块6",
                "扩展模块7",
                "扩展模块8",
                "扩展模块9",
                "扩展模块10",
                "扩展模块11",
                "扩展模块12",
                "扩展模块13",
                "扩展模块14",
                "扩展模块15",
                "扩展模块16",
                "扩展模块17",
                "扩展模块18",
                "扩展模块19",
                "扩展模块20"))
        recyclerView.adapter = adapter
    }
}