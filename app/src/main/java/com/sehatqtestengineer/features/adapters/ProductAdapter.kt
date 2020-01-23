package com.sehatqtestengineer.features.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.sehatqtestengineer.databinding.ItemProductBinding
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.R
import com.sehatqtestengineer.features.ui.DetailActivity
import com.sehatqtestengineer.viewmodel.ProductViewModel

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var productList: List<Product>
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding:ItemProductBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_product, parent,false)
        this.context = parent.context

        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return if(::productList.isInitialized) productList.size else 0
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position], position, context)
        holder.getBind().cvProduct.setOnClickListener {
            Log.d("Test", "position: " + holder.getBind().viewModel!!.getPosition().value)
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("product_item", productList[position!!])
            context.startActivity(intent)
        }
    }

    fun updateProductList(list: List<Product>) {
        productList = list
        Log.d("Test", "size: " + productList.size)
        notifyDataSetChanged()
    }

    class ProductViewHolder(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root) {

        private val viewModel = ProductViewModel()

        fun bind(product: Product, position: Int, context: Context) {
            viewModel.bind(product, position, context)
            binding.viewModel = viewModel
        }

        fun getBind(): ItemProductBinding {

            return binding
        }

    }
}