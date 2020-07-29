package com.devnunu.zipcheck.ui.inputtemplate.category.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.checklist.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemInputTemplateItemBinding
import com.devnunu.zipcheck.ui.inputtemplate.category.InputTemplateItemListener

class ChecklistItemAdapter(
    val inputTemplateItemListener: InputTemplateItemListener,
    val categoryName: String?
) :
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
        return checklistItems.mapIndexed { index, item ->
            ChecklistItem(item, index)
        }
    }

    inner class CategoryViewHolder(private val binding: ItemInputTemplateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChecklistItem?) {
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