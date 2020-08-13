package com.devnunu.zipcheck.ui.inputtemplateitem.category.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemInputTemplateItemBinding
import com.devnunu.zipcheck.ui.inputtemplateitem.category.InputTemplateItemListener

class InputChecklistItemAdapter(
    val inputTemplateItemListener: InputTemplateItemListener,
    val categoryName: String?
) :
    RecyclerView.Adapter<InputChecklistItemAdapter.CategoryViewHolder>() {

    private val checklistChecklistItem: MutableList<InputChecklistItem> = mutableListOf()

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

    private fun getChecklistItem(checklistItems: List<CheckItem>): List<InputChecklistItem> {
        return checklistItems.mapIndexed { index, item ->
            InputChecklistItem(item, index)
        }
    }

    inner class CategoryViewHolder(private val binding: ItemInputTemplateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InputChecklistItem?) {
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
            val adapter = recyclerView.adapter as InputChecklistItemAdapter?
            checklistItems?.let {
                adapter?.setItem(it)
            }
        }
    }
}