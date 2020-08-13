package com.devnunu.zipcheck.ui.inputtemplateitem.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.template.model.CheckItem
import com.devnunu.zipcheck.databinding.ItemInputTemplateBinding

class InputTemplateItemAdapter(val listener: InputTemplateItemListener) :
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

    fun addItem(checkItem: CheckItem) {
        checkItems.add(0, checkItem)
        listener.onChangeCheckItems(checkItems)
        notifyItemInserted(0)
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
}