package com.sehatqtestengineer.features.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sehatqtestengineer.R
import com.sehatqtestengineer.databinding.ItemPurchaseBinding
import com.sehatqtestengineer.features.ui.DetailActivity
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.viewmodel.PurchaseListViewModel

class PurchaseAdapter: RecyclerView.Adapter<PurchaseAdapter.PurchaseViewHolder>() {

    private lateinit var productList: List<Product>
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val binding:ItemPurchaseBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_purchase, parent,false)
        this.context = parent.context

        return PurchaseViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return if(::productList.isInitialized) productList.size else 0
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(productList[position], position, context)
        holder.getBind().clPurchaseContainer.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("product_item", productList[position!!])
            context.startActivity(intent)
        }
    }

    fun updatePurchaseList(list: List<Product>) {
        productList = list
        Log.d("Test", "size purchaseList: " + productList.size)
        notifyDataSetChanged()
    }

    class PurchaseViewHolder(private val binding: ItemPurchaseBinding): RecyclerView.ViewHolder(binding.root) {

        private val viewModel = PurchaseListViewModel()

        fun bind(product: Product, position: Int, context: Context) {
            viewModel.bind(product, position, context)
            binding.viewModel = viewModel
        }

        fun getBind(): ItemPurchaseBinding {

            return binding
        }

    }
}