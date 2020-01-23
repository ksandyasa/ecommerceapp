package com.sehatqtestengineer.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.sehatqtestengineer.model.Product

class ProductViewModel: BaseViewModel() {

    private val productTitle = MutableLiveData<String>()
    private val productImageUrl = MutableLiveData<String>()
    private val productLoved = MutableLiveData<Int>()
    private val productPrice = MutableLiveData<String>()
    private val itemPosition = MutableLiveData<Int>()
    private val productContext = MutableLiveData<Context>()

    fun bind(product: Product, position: Int, context: Context) {
        productTitle.value = product.title
        productImageUrl.value = product.imageUrl
        productLoved.value = product.loved
        productPrice.value = product.price
        itemPosition.value = position
        productContext.value = context
    }

    fun getProductTitle(): MutableLiveData<String> {

        return productTitle
    }

    fun getProductImageUrl(): MutableLiveData<String> {

        return productImageUrl
    }

    fun getProductLoved(): MutableLiveData<Int> {

        return productLoved
    }

    fun getProductPrice(): MutableLiveData<String> {

        return productPrice
    }

    fun getPosition(): MutableLiveData<Int> {

        return itemPosition
    }

    fun getProductContext(): MutableLiveData<Context> {

        return productContext
    }

}