package com.sehatqtestengineer.features.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sehatqtestengineer.R
import com.sehatqtestengineer.databinding.ContentDetailBinding
import com.sehatqtestengineer.di.ViewModelFactory
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.viewmodel.DetailViewModel

class DetailActivity: AppCompatActivity() {

    private lateinit var binding: ContentDetailBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.content_detail)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(DetailViewModel::class.java)
        val product = intent.extras.get("product_item") as Product
        viewModel.bind(product)
        binding.viewModel = viewModel

        setSupportActionBar(binding.tbDetail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        binding.btnLovedDetail.setOnClickListener {
            if (binding.btnLovedDetail.drawable.constantState == resources.getDrawable(R.drawable.icon_love_fill).constantState) {
                binding.btnLovedDetail.setImageResource(R.drawable.icon_love_empty)
            } else {
                binding.btnLovedDetail.setImageResource(R.drawable.icon_love_fill)
            }
        }

        binding.btnPurchaseDetail.setOnClickListener {
            binding.viewModel!!.purchaseDetail(product)
            binding.viewModel!!.getPurchased().observe(this, Observer {result ->
                Log.d("Test", "purchased: " + result?:"")
                Toast.makeText(this@DetailActivity, result?:"", Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }

}