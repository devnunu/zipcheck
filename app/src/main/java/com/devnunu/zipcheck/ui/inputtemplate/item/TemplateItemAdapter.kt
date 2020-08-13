package com.devnunu.zipcheck.ui.inputtemplate.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.template.model.Template
import com.devnunu.zipcheck.databinding.ItemInputChecklistTemplateBinding

class TemplateItemAdapter(val listener: TemplateItemListener) :
    RecyclerView.Adapter<TemplateItemAdapter.TemplateViewHolder>() {

    private val categoryItemList: MutableList<TemplateItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TemplateViewHolder {
        val binding = ItemInputChecklistTemplateBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TemplateViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TemplateViewHolder,
        position: Int
    ) {
        val viewModel = categoryItemList[position]
        holder.bind(viewModel)
    }

    override fun getItemCount(): Int {
        return categoryItemList.size
    }

    private fun setItem(templates: List<Template>, selIndex: Int?) {
        categoryItemList.clear()
        categoryItemList.addAll(getChecklistItem(templates, selIndex))
        notifyDataSetChanged()
    }

    private fun getChecklistItem(
        templates: List<Template>,
        selIndex: Int?
    ): List<TemplateItem> {
        return templates.mapIndexed { index, checklist ->
            TemplateItem(checklist, index, selIndex == index)
        }
    }

    inner class TemplateViewHolder(private val binding: ItemInputChecklistTemplateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TemplateItem?) {
            binding.also {
                it.item = item
                it.listener = listener
                it.executePendingBindings()
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["items", "selIndex"])
        fun bindItem(
            recyclerView: RecyclerView,
            templates: List<Template>?,
            selIndex: Int?
        ) {
            val adapter = recyclerView.adapter as TemplateItemAdapter?
            templates?.let {
                adapter?.setItem(it, selIndex)
            }
        }
    }
}