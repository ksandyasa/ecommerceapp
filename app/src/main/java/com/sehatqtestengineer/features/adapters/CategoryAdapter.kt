package com.sehatqtestengineer.features.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sehatqtestengineer.R
import com.sehatqtestengineer.databinding.ItemCategoryBinding
import com.sehatqtestengineer.model.Category
import com.sehatqtestengineer.viewmodel.CategoryViewModel

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private lateinit var categoryList: List<Category>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding:ItemCategoryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_category, parent,false)

        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return if(::categoryList.isInitialized) categoryList.size else 0
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    fun updateCategoryList(list: List<Category>) {
        categoryList = list
        Log.d("Test", "size: " + categoryList.size)
        notifyDataSetChanged()
    }

    class CategoryViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root) {

        private val viewModel = CategoryViewModel()

        fun bind(category: Category) {
            viewModel.bind(category)
            binding.viewModel = viewModel
        }

    }
}