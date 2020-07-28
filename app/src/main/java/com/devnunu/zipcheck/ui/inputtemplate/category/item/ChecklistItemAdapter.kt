package com.devnunu.zipcheck.ui.inputtemplate.category.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.checklist.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemInputTemplateItemBinding

class ChecklistItemAdapter :
    RecyclerView.Adapter<ChecklistItemAdapter.CategoryViewHolder>() {

    private val checklistChecklistItem: MutableList<ChecklistItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemInputTemplateItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
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

    private fun getChecklistItem(checklistItems: List<CheckItem>): List<ChecklistItem> {
        return checklistItems.map {
            ChecklistItem(it)
        }

    }

    inner class CategoryViewHolder(private val binding: ItemInputTemplateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChecklistItem?) {
            binding.item = item
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["items"])
        fun bindItem(
            recyclerView: RecyclerView,
            checklistItems: List<CheckItem>?
        ) {
            val adapter = recyclerView.adapter as ChecklistItemAdapter?
            checklistItems?.let {
                adapter?.setItem(it)
            }
        }
    }
}