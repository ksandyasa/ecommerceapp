package com.sehatqtestengineer.features.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sehatqtestengineer.R
import com.sehatqtestengineer.databinding.ItemPurchaseBinding
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.viewmodel.ProductViewModel

class PurchaseAdapter: RecyclerView.Adapter<PurchaseAdapter.PurchaseViewHolder>() {

    private lateinit var productList: List<Product>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val binding:ItemPurchaseBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_purchase, parent,false)

        return PurchaseViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return if(::productList.isInitialized) productList.size else 0
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun updateProductList(list: List<Product>) {
        productList = list
        Log.d("Test", "size: " + productList.size)
        notifyDataSetChanged()
    }

    class PurchaseViewHolder(private val binding: ItemPurchaseBinding): RecyclerView.ViewHolder(binding.root) {

        private val viewModel = ProductViewModel()

        fun bind(product: Product) {
            viewModel.bind(product)
            binding.viewModel = viewModel
        }

    }
}