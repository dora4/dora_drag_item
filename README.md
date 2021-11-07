# DoraDragItem

描述：一个可以拖动排序的条目控制器

复杂度：★★☆☆☆

分组：【Dora大控件组】

关系：暂无

技术要点：ItemTouchHelper

### 照片

![avatar](https://github.com/dora4/dora_drag_item/blob/main/art/dora_drag_item.jpg)

### 动图

![avatar](https://github.com/dora4/dora_drag_item/blob/main/art/dora_drag_item.gif)

### 软件包

https://github.com/dora4/dora_drag_item/blob/main/art/dora_drag_item.apk

### 用法

```kotlin
val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = DoraDragItemAdapter()
        val touchHelper = ItemTouchHelper(DoraDragItemCallback(adapter))
        touchHelper.attachToRecyclerView(recyclerView)
```
