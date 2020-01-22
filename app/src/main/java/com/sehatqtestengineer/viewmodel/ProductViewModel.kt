package com.sehatqtestengineer.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sehatqtestengineer.model.Product

class ProductViewModel: BaseViewModel() {

    private val productTitle = MutableLiveData<String>()
    private val productImageUrl = MutableLiveData<String>()
    private val productLoved = MutableLiveData<Int>()
    private val productPrice = MutableLiveData<String>()

    fun bind(product: Product) {
        productTitle.value = product.title
        productImageUrl.value = product.imageUrl
        productLoved.value = product.loved
        productPrice.value = product.price
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

}