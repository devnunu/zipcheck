package com.devnunu.zipcheck.ui.template.category.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.checklist.model.ChecklistItem
import com.devnunu.zipcheck.databinding.ItemInputChecklistTemplateItemBinding

class ChecklistTemplateItemAdapter :
    RecyclerView.Adapter<ChecklistTemplateItemAdapter.CategoryViewHolder>() {

    private val checklistTemplateItem: MutableList<ChecklistTemplateItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemInputChecklistTemplateItemBinding.inflate(
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
        val item = checklistTemplateItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return checklistTemplateItem.size
    }

    private fun setItem(checklistItems: List<ChecklistItem>) {
        checklistTemplateItem.clear()
        checklistTemplateItem.addAll(getChecklistItem(checklistItems))
        notifyDataSetChanged()
    }

    private fun getChecklistItem(checklistItems: List<ChecklistItem>): List<ChecklistTemplateItem> {
        return checklistItems.map {
            ChecklistTemplateItem(it)
        }

    }

    inner class CategoryViewHolder(private val binding: ItemInputChecklistTemplateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChecklistTemplateItem?) {
            binding.item = item
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["items"])
        fun bindItem(
            recyclerView: RecyclerView,
            checklistItems: List<ChecklistItem>?
        ) {
            val adapter = recyclerView.adapter as ChecklistTemplateItemAdapter?
            checklistItems?.let {
                adapter?.setItem(it)
            }
        }
    }
}