package com.devnunu.zipcheck.ui.inputtemplate.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.databinding.ItemInputTemplateCategoryBinding
import com.devnunu.zipcheck.ui.inputtemplate.category.item.InputChecklistItemAdapter

class InputChecklistCategoryItemAdapter(
    val inputTemplateItemListener: InputTemplateItemListener
) :
    RecyclerView.Adapter<InputChecklistCategoryItemAdapter.CategoryViewHolder>() {

    private val categoryItemList: MutableList<InputChecklistCategoryItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemInputTemplateCategoryBinding.inflate(
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
        val viewModel = categoryItemList[position]
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
        return categoryItemList.size
    }

    private fun setItem(categoryNameList: List<String>, checklist: Checklist) {
        categoryItemList.clear()
        categoryItemList.addAll(getChecklistItem(categoryNameList, checklist))
        notifyDataSetChanged()
    }

    private fun getChecklistItem(
        categoryNameList: List<String>,
        checklist: Checklist
    ): List<InputChecklistCategoryItem> {
        return categoryNameList.map {
            val checklistItems = checklist.items?.get(it)
            InputChecklistCategoryItem(it, checklistItems)
        }

    }

    inner class CategoryViewHolder(private val binding: ItemInputTemplateCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InputChecklistCategoryItem?) {
            binding.also {
                it.item = item
                it.listChecklistItem.adapter =
                    InputChecklistItemAdapter(inputTemplateItemListener, item?.categoryName)
                it.listener = inputTemplateItemListener
                it.executePendingBindings()
            }
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["categoryNames", "checklist"])
        fun bindItem(
            recyclerView: RecyclerView,
            categoryNameList: List<String>?,
            checklist: Checklist?
        ) {
            val adapter = recyclerView.adapter as InputChecklistCategoryItemAdapter?
            if (categoryNameList != null && checklist != null) {
                adapter?.setItem(categoryNameList, checklist)
            }
        }
    }
}