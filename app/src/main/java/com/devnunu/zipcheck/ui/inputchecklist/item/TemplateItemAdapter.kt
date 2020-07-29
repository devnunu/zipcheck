package com.devnunu.zipcheck.ui.inputchecklist.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devnunu.zipcheck.data.checklist.model.Checklist
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

    private fun setItem(checklists: List<Checklist>, selIndex: Int?) {
        categoryItemList.clear()
        categoryItemList.addAll(getChecklistItem(checklists, selIndex))
        notifyDataSetChanged()
    }

    private fun getChecklistItem(
        checklists: List<Checklist>,
        selIndex: Int?
    ): List<TemplateItem> {
        return checklists.mapIndexed { index, checklist ->
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
            checklists: List<Checklist>?,
            selIndex: Int?
        ) {
            val adapter = recyclerView.adapter as TemplateItemAdapter?
            checklists?.let {
                adapter?.setItem(it, selIndex)
            }
        }
    }
}