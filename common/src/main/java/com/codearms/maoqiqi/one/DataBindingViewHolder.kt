package com.codearms.maoqiqi.one

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolder<DB : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: DB = DataBindingUtil.bind(itemView) ?: throw IllegalStateException("DataBindingUtil.bind fail")
}