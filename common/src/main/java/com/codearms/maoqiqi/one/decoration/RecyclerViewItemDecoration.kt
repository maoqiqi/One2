package com.codearms.maoqiqi.one.decoration

import android.graphics.Canvas
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.codearms.maoqiqi.log.LogUtils

class RecyclerViewItemDecoration(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int,
    center: Int
) : RecyclerView.ItemDecoration() {

    private val halfCenter = center / 2
    private var orientation = -1

    @JvmOverloads
    constructor(margin: Int = 16) : this(margin, margin)

    @JvmOverloads
    constructor(horizontal: Int, vertical: Int, center: Int = vertical) : this(horizontal, vertical, horizontal, vertical, center)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        // 当前位置
        val position = parent.getChildLayoutPosition(view)
//        LogUtils.e("getItemOffsets outRect:", outRect.top, outRect.right, outRect.bottom, outRect.left, position)
        val itemCount: Int = parent.adapter?.itemCount ?: 0
        LogUtils.e("====================================",outRect)
        if (parent.layoutManager != null) {
            when (val manager = parent.layoutManager) {
                is GridLayoutManager -> setGridLayoutManager(outRect, manager.orientation, position, itemCount, manager.spanCount)
                is StaggeredGridLayoutManager -> {
                    orientation = manager.orientation
                    setStaggeredGridLayoutManager(outRect, view, parent, manager.spanCount)
                }
                is LinearLayoutManager -> setLinearLayoutManager(outRect, manager.orientation, position, itemCount)
            }
        }
        LogUtils.e(outRect)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        LogUtils.e("onDraw")
    }

    private fun setGridLayoutManager(outRect: Rect, orientation: Int, position: Int, itemCount: Int, spanCount: Int) {
        LogUtils.e("setGridLayoutManager:orientation:$orientation,position:$position,itemCount:$itemCount,spanCount:$spanCount")
        if (spanCount == 1) { // 一列
            setLinearLayoutManager(outRect, orientation, position, itemCount)
        } else {
            if (orientation == LinearLayoutManager.VERTICAL) { // 垂直方向
                when ((position + 1) % spanCount) {
                    1 -> outRect.set(left, 0, halfCenter, 0) // 第一列
                    0 -> outRect.set(halfCenter, 0, right, 0) // 最后一列
                    else -> outRect.set(halfCenter, 0, halfCenter, 0) // 中间列
                }
                // 共计一行
                if (itemCount <= spanCount) {
                    outRect.top = top
                    outRect.bottom = bottom
                } else {
                    val lastLineIndex = if (itemCount % spanCount == 0) itemCount - spanCount else itemCount - itemCount % spanCount
                    when {
                        position < spanCount -> { // 第一行
                            outRect.top = top
                            outRect.bottom = halfCenter
                        }
                        position >= lastLineIndex -> { // 最后一行
                            outRect.top = halfCenter
                            outRect.bottom = bottom
                        }
                        else -> {
                            outRect.top = halfCenter
                            outRect.bottom = halfCenter
                        }
                    }
                }
            } else if (orientation == LinearLayoutManager.HORIZONTAL) { // 水平方向
                LogUtils.e(position % spanCount)
//                when (position % spanCount) {
//                    0 -> outRect.set(0, 50, 0, halfCenter) // 第一行
//                    spanCount - 1 -> outRect.set(0, halfCenter, 0, 0) // 最后一行
//                    else -> outRect.set(0, 10, 0, 10) // 中间行
//                }
                if (position==0){
                    outRect.top =10
                }
                // 共计一列
                if (itemCount <= spanCount) {
                    outRect.left = left
                    outRect.right = right
                } else {
                    val lastLineIndex = if (itemCount % spanCount == 0) itemCount - spanCount else itemCount - itemCount % spanCount
                    when {
                        position < spanCount -> { // 第一列
                            outRect.left = left
                            outRect.right = halfCenter
                        }
                        position >= lastLineIndex -> { // 最后一列
                            outRect.left = halfCenter
                            outRect.right = right
                        }
                        else -> {
                            outRect.left = halfCenter
                            outRect.right = halfCenter
                        }
                    }
                }
            }
        }
    }

    private fun setStaggeredGridLayoutManager(outRect: Rect, view: View, parent: RecyclerView, spanCount: Int) {
        if (parent.adapter == null) return

        // 当前位置
        val position = parent.getChildLayoutPosition(view)
        // 总数量
        val count = parent.adapter!!.itemCount
        val params = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
        // 获取item在span中的下标
        val spanIndex = params.spanIndex
        Log.e("info", "position:$position,spanIndex:$spanIndex")
        outRect.right = right
        if (spanIndex == 0) {
            outRect.left = left
        }
    }

    private fun setLinearLayoutManager(outRect: Rect, orientation: Int, position: Int, itemCount: Int) {
        LogUtils.e("setLinearLayoutManager:position:$position,itemCount:$itemCount")
        // 共计一行或一列
        if (itemCount == 1) {
            outRect.set(left, top, right, bottom)
            return
        }
        if (orientation == LinearLayoutManager.VERTICAL) { // 垂直方向
            when (position) {
                0 -> outRect.set(left, top, right, halfCenter)
                itemCount - 1 -> outRect.set(left, halfCenter, right, bottom)
                else -> outRect.set(left, halfCenter, right, halfCenter)
            }
        } else if (orientation == LinearLayoutManager.HORIZONTAL) { // 水平方向
            when (position) {
                0 -> outRect.set(left, top, halfCenter, bottom)
                itemCount - 1 -> outRect.set(halfCenter, top, right, bottom)
                else -> outRect.set(halfCenter, top, halfCenter, bottom)
            }
        }
    }
}