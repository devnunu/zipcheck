package com.devnunu.zipcheck.ui.housedetail.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.checklist.model.Checklist
import com.devnunu.zipcheck.databinding.ItemHouseDetailCategoryBinding
import com.devnunu.zipcheck.ui.housedetail.category.item.HouseChecklistItemAdapter

class HouseChecklistCategoryItemAdapter(
    val inputTemplateItemListener: HouseChecklistItemListener
) :
    RecyclerView.Adapter<HouseChecklistCategoryItemAdapter.CategoryViewHolder>() {

    private val categoryItemList: MutableList<HouseChecklistCategoryItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemHouseDetailCategoryBinding.inflate(
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
    ): List<HouseChecklistCategoryItem> {
        return categoryNameList.map {
            val checklistItems = checklist.items?.get(it)
            HouseChecklistCategoryItem(it, checklistItems)
        }

    }

    inner class CategoryViewHolder(private val binding: ItemHouseDetailCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HouseChecklistCategoryItem?) {
            binding.also {
                it.item = item
                it.listChecklistItem.adapter =
                    HouseChecklistItemAdapter(inputTemplateItemListener, item?.categoryName)
                it.executePendingBindings()
            }
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["categoryNames", "houseChecklist"])
        fun bindItem(
            recyclerView: RecyclerView,
            categoryNameList: List<String>?,
            checklist: Checklist?
        ) {
            val adapter = recyclerView.adapter as HouseChecklistCategoryItemAdapter?
            if (categoryNameList != null && checklist != null) {
                adapter?.setItem(categoryNameList, checklist)
            }
        }
    }
}