package com.devnunu.zipcheck.ui.housedetail.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemHouseDetailChecklistBinding

class ChecklistItemAdapter(val listener: ChecklistItemListener) :
    RecyclerView.Adapter<ChecklistItemAdapter.ChecklistItemViewHolder>() {

    private val houseItemList: MutableList<ChecklistItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChecklistItemViewHolder {
        val binding = ItemHouseDetailChecklistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChecklistItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ChecklistItemViewHolder,
        position: Int
    ) {
        val viewModel = houseItemList[position]
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
        return houseItemList.size
    }

    private fun setItem(checkItemList: List<CheckItem>) {
        houseItemList.clear()
        houseItemList.addAll(getHouseItem(checkItemList))
        notifyDataSetChanged()
    }

    private fun getHouseItem(
        checkItemList: List<CheckItem>
    ): List<ChecklistItem> {
        return checkItemList.map {
            ChecklistItem(it)
        }
    }

    inner class ChecklistItemViewHolder(private val binding: ItemHouseDetailChecklistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChecklistItem?) {
            binding.also {
                it.item = item
                it.listener = listener
                it.executePendingBindings()
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["items"])
        fun bindItem(
            recyclerView: RecyclerView,
            items: List<CheckItem>?
        ) {
            val adapter = recyclerView.adapter as ChecklistItemAdapter?
            items?.let {
                adapter?.setItem(it)
            }
        }
    }
}