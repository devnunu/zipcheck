package com.devnunu.zipcheck.ui.common.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.databinding.ItemCommonBottomSheetBinding
import java.util.ArrayList

class BottomSheetItemAdapter() :
    RecyclerView.Adapter<BottomSheetItemAdapter.BottomSheetViewHolder>() {

    private val items: ArrayList<String> = ArrayList()

    private var listener: BottomSheetListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BottomSheetViewHolder {
        val binding =
            ItemCommonBottomSheetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return BottomSheetViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(
        holder: BottomSheetViewHolder,
        position: Int
    ) {
        val viewModel = items[position]
        holder.bind(viewModel, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun setItems(items: ArrayList<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun replaceData(
        items: ArrayList<String>,
        listener: BottomSheetListener?
    ) {
        setItems(items)
        this.listener = listener
    }

    inner class BottomSheetViewHolder(private val binding: ItemCommonBottomSheetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String?, listener: BottomSheetListener?) {
            binding.title = title
            binding.listener = listener
        }

    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["items", "onClickItem"], requireAll = false)
        fun bindItem(
            recyclerView: RecyclerView,
            items: ArrayList<String>,
            listener: BottomSheetListener?
        ) {
            val adapter =
                recyclerView.adapter as BottomSheetItemAdapter?
            adapter?.replaceData(items, listener)
        }
    }

}