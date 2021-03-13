package com.codearms.maoqiqi.one

import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

abstract class AppBarStateChangeListener(private val everyTimeChangeCallBack: Boolean = false) : AppBarLayout.OnOffsetChangedListener {

    enum class State { EXPANDED, COLLAPSED, IDLE }

    private var mCurrentState = State.IDLE

    override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
        val percentage = String.format("%.2f", abs(i).toFloat() / appBarLayout.totalScrollRange).toFloat()
        if (abs(i) == 0) {
            if (everyTimeChangeCallBack || mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED, percentage)
            }
            mCurrentState = State.EXPANDED
        } else if (abs(i) >= appBarLayout.totalScrollRange) {
            if (everyTimeChangeCallBack || mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED, percentage)
            }
            mCurrentState = State.COLLAPSED
        } else {
            if (everyTimeChangeCallBack || mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE, percentage)
            }
            mCurrentState = State.IDLE
        }
    }

    abstract fun onStateChanged(appBarLayout: AppBarLayout, state: State, percentage: Float)
}