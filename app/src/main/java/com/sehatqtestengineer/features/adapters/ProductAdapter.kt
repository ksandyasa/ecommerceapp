package com.sehatqtestengineer.features.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sehatqtestengineer.databinding.ItemProductBinding
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.R
import com.sehatqtestengineer.viewmodel.ProductViewModel

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var productList: List<Product>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding:ItemProductBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_product, parent,false)

        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return if(::productList.isInitialized) productList.size else 0
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun updateProductList(list: List<Product>) {
        productList = list
        Log.d("Test", "size: " + productList.size)
        notifyDataSetChanged()
    }

    class ProductViewHolder(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root) {

        private val viewModel = ProductViewModel()

        fun bind(product: Product) {
            viewModel.bind(product)
            binding.viewModel = viewModel
        }
    }
}