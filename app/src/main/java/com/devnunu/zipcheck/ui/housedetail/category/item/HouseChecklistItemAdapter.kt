package com.devnunu.zipcheck.ui.housedetail.category.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemHouseDetailChecklistItemBinding
import com.devnunu.zipcheck.ui.housedetail.category.HouseChecklistItemListener

class HouseChecklistItemAdapter(
    val inputTemplateItemListener: HouseChecklistItemListener,
    val categoryName: String?
) :
    RecyclerView.Adapter<HouseChecklistItemAdapter.ChecklistItemViewHolder>() {

    private val checklistChecklistItem: MutableList<HouseChecklistItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChecklistItemViewHolder {
        val binding = ItemHouseDetailChecklistItemBinding.inflate(
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
        val item = checklistChecklistItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return checklistChecklistItem.size
    }

    private fun setItem(checklistItems: List<CheckItem>) {
        checklistChecklistItem.clear()
        checklistChecklistItem.addAll(getChecklistItem(checklistItems))
        notifyDataSetChanged()
    }

    private fun getChecklistItem(checklistItems: List<CheckItem>): List<HouseChecklistItem> {
        return checklistItems.mapIndexed { index, item ->
            HouseChecklistItem(item, index)
        }
    }

    inner class ChecklistItemViewHolder(private val binding: ItemHouseDetailChecklistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HouseChecklistItem?) {
            binding.also {
                it.item = item
                it.categoryName = categoryName
                it.listener = inputTemplateItemListener
                it.executePendingBindings()
            }
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["houseChecklistItems"])
        fun bindItem(
            recyclerView: RecyclerView,
            checklistItems: List<CheckItem>?
        ) {
            val adapter = recyclerView.adapter as HouseChecklistItemAdapter?
            checklistItems?.let {
                adapter?.setItem(it)
            }
        }
    }
}