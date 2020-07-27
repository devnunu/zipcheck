package com.devnunu.zipcheck.ui.template.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.databinding.ItemInputChecklistTemplateCategoryBinding

class CategoryItemAdapter(private val checklist: Checklist) :
    RecyclerView.Adapter<CategoryItemAdapter.CategoryViewHolder>() {

    private val categoryItemList: MutableList<CategoryItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemInputChecklistTemplateCategoryBinding.inflate(
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

    private fun setItem(categoryNameList: List<String>) {
        categoryItemList.clear()
        categoryItemList.addAll(getChecklistItem(categoryNameList))
        notifyDataSetChanged()
    }

    private fun getChecklistItem(categoryNameList: List<String>): List<CategoryItem> {
        return categoryNameList.map {
            val checklistItems = checklist.items[it]
            CategoryItem(it, checklistItems)
        }

    }

    inner class CategoryViewHolder(private val binding: ItemInputChecklistTemplateCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem?) {
            binding.item = item
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["categoryNames"])
        fun bindItem(
            recyclerView: RecyclerView,
            categoryNameList: List<String>?
        ) {
            val adapter = recyclerView.adapter as CategoryItemAdapter?
            categoryNameList?.let {
                adapter?.setItem(it)
            }
        }
    }
}