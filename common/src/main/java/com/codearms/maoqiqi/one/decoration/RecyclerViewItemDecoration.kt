package com.codearms.maoqiqi.one.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerViewItemDecoration(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int,
    center: Int
) : RecyclerView.ItemDecoration() {

    private val halfCenter = center / 2

    @JvmOverloads
    constructor(margin: Int = 16) : this(margin, margin)

    @JvmOverloads
    constructor(horizontal: Int, vertical: Int, center: Int = vertical) : this(horizontal, vertical, horizontal, vertical, center)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        // 当前位置
        val position = parent.getChildLayoutPosition(view)
        val itemCount: Int = parent.adapter?.itemCount ?: 0
        if (parent.layoutManager != null) {
            when (val manager = parent.layoutManager) {
                is GridLayoutManager -> setGridLayoutManager(outRect, manager, position, itemCount)
                is LinearLayoutManager -> setLinearLayoutManager(outRect, manager.orientation, position, itemCount)
                is StaggeredGridLayoutManager -> setStaggeredGridLayoutManager(outRect, view, manager, position, itemCount)
            }
        }
    }

    private fun setGridLayoutManager(outRect: Rect, manager: GridLayoutManager, position: Int, itemCount: Int) {
        val orientation = manager.orientation
        val spanCount = manager.spanCount
        if (spanCount == 1) { // 一列
            setLinearLayoutManager(outRect, manager.orientation, position, itemCount)
        } else {
            if (orientation == LinearLayoutManager.VERTICAL) { // 垂直方向
                // 列
                when (position % spanCount) {
                    0 -> outRect.set(left, 0, halfCenter, 0)
                    spanCount - 1 -> outRect.set(halfCenter, 0, right, 0)
                    else -> outRect.set(halfCenter, 0, halfCenter, 0)
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
                // 行
                when (position % spanCount) {
                    0 -> outRect.set(0, top, 0, halfCenter)
                    spanCount - 1 -> outRect.set(0, halfCenter, 0, bottom)
                    else -> outRect.set(0, halfCenter, 0, halfCenter)
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

    private fun setLinearLayoutManager(outRect: Rect, orientation: Int, position: Int, itemCount: Int) {
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

    private fun setStaggeredGridLayoutManager(outRect: Rect, view: View, manager: StaggeredGridLayoutManager, position: Int, itemCount: Int) {
        val orientation = manager.orientation
        val spanCount = manager.spanCount
        if (spanCount == 1) { // 一列
            setLinearLayoutManager(outRect, manager.orientation, position, itemCount)
        } else {
            val params = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
            // 获取item在span中的下标
            val spanIndex = params.spanIndex
            if (orientation == LinearLayoutManager.VERTICAL) { // 垂直方向
                // 列
                when (spanIndex) {
                    0 -> outRect.set(left, 0, halfCenter, 0)
                    spanCount - 1 -> outRect.set(halfCenter, 0, right, 0)
                    else -> outRect.set(halfCenter, 0, halfCenter, 0)
                }
                // 共计一行
                if (itemCount <= spanCount) {
                    outRect.top = top
                    outRect.bottom = bottom
                } else {
                    if (position < spanCount) { // 第一行
                        outRect.top = top
                        outRect.bottom = halfCenter
                    } else {
                        outRect.top = halfCenter
                        outRect.bottom = halfCenter
                    }
                }
            } else if (orientation == LinearLayoutManager.HORIZONTAL) { // 水平方向
                // 行
                when (spanIndex) {
                    0 -> outRect.set(0, top, 0, halfCenter)
                    spanCount - 1 -> outRect.set(0, halfCenter, 0, bottom)
                    else -> outRect.set(0, halfCenter, 0, halfCenter)
                }
                // 共计一列
                if (itemCount <= spanCount) {
                    outRect.left = left
                    outRect.right = right
                } else {
                    if (position < spanCount) { // 第一列
                        outRect.left = left
                        outRect.right = halfCenter
                    } else {
                        outRect.left = halfCenter
                        outRect.right = halfCenter
                    }
                }
            }
        }
    }
}