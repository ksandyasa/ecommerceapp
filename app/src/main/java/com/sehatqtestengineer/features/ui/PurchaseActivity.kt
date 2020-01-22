package com.sehatqtestengineer.features.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sehatqtestengineer.databinding.ContentPurchaseBinding
import com.sehatqtestengineer.R
import com.sehatqtestengineer.viewmodel.PurchaseViewModel

class PurchaseActivity: AppCompatActivity() {

    private lateinit var binding: ContentPurchaseBinding
    private lateinit var viewModel: PurchaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.content_purchase)

        viewModel = ViewModelProviders.of(this).get(PurchaseViewModel::class.java)
        binding.viewModel = viewModel

        setSupportActionBar(binding.tbPurchase)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }

}