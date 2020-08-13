package com.devnunu.zipcheck.ui.inputtemplateitem.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemInputTemplateBinding

class InputTemplateItemAdapter :
    RecyclerView.Adapter<InputTemplateItemAdapter.CategoryViewHolder>() {

    private val checkItems: MutableList<CheckItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemInputTemplateBinding.inflate(
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
        val viewModel = checkItems[position]
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
        return checkItems.size
    }

    private fun setItem(checkItems: List<CheckItem>) {
        this.checkItems.clear()
        this.checkItems.addAll(checkItems)
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(private val binding: ItemInputTemplateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CheckItem?) {
            binding.also {
                it.item = item
                it.executePendingBindings()
            }
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["templateItems"])
        fun bindItem(
            recyclerView: RecyclerView,
            checkItems: MutableList<CheckItem>?
        ) {
            val adapter = recyclerView.adapter as InputTemplateItemAdapter?
            checkItems?.let {
                adapter?.setItem(checkItems)
            }
        }
    }
}