package com.sehatqtestengineer.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.sehatqtestengineer.model.Product

class PurchaseListViewModel: BaseViewModel() {

    private val purchaseTitle = MutableLiveData<String>()
    private val purchaseImageUrl = MutableLiveData<String>()
    private val purchaseLoved = MutableLiveData<Int>()
    private val purchasePrice = MutableLiveData<String>()
    private val itemPosition = MutableLiveData<Int>()
    private val purchaseContext = MutableLiveData<Context>()

    fun bind(product: Product, position: Int, context: Context) {
        purchaseTitle.value = product.title
        purchaseImageUrl.value = product.imageUrl
        purchaseLoved.value = product.loved
        purchasePrice.value = product.price
        itemPosition.value = position
        purchaseContext.value = context
    }

    fun getPurchaseTitle(): MutableLiveData<String> {

        return purchaseTitle
    }

    fun getPurchaseImageUrl(): MutableLiveData<String> {

        return purchaseImageUrl
    }

    fun getPurchaseLoved(): MutableLiveData<Int> {

        return purchaseLoved
    }

    fun getPurchasePrice(): MutableLiveData<String> {

        return purchasePrice
    }

    fun getPosition(): MutableLiveData<Int> {

        return itemPosition
    }

    fun getPurchaseContext(): MutableLiveData<Context> {

        return purchaseContext
    }

}