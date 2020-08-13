package com.devnunu.zipcheck.ui.inputtemplateitem.item

import androidx.recyclerview.widget.RecyclerView


interface OnStartActionListener {
    fun onStartDrag(viewHolder: RecyclerView.ViewHolder?)
    fun onStartSwipe(viewHolder: RecyclerView.ViewHolder?)
}