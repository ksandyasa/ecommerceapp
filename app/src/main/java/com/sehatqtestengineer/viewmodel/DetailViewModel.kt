package com.sehatqtestengineer.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.model.ProductDao
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DetailViewModel(private val productDao: ProductDao): BaseViewModel() {

    private val detailTitle = MutableLiveData<String>()
    private val detailDesc = MutableLiveData<String>()
    private val detailImageUrl = MutableLiveData<String>()
    private val detailLoved = MutableLiveData<Int>()
    private val detailPrice = MutableLiveData<String>()
    private val purchased = MutableLiveData<String>()


    private lateinit var subscription: Disposable

    fun bind(product: Product) {
        detailTitle.value = product.title
        detailDesc.value = product.description
        detailImageUrl.value = product.imageUrl
        detailLoved.value = product.loved
        detailPrice.value = product.price
    }

    fun getDetailTitle(): MutableLiveData<String> {

        return detailTitle
    }

    fun getDetailDesc(): MutableLiveData<String> {

        return detailDesc
    }

    fun getDetailImageUrl(): MutableLiveData<String> {

        return detailImageUrl
    }

    fun getDetailLoved(): MutableLiveData<Int> {

        return detailLoved
    }

    fun getDetailPrice(): MutableLiveData<String> {

        return detailPrice
    }

    fun purchaseDetail(product: Product) {
        subscription = Observable.just(productDao)
            .subscribeOn(Schedulers.io())
            .doOnTerminate { onRetrieveDetailFinishPurchased() }
            .subscribe (
                { db ->
                    db.insertAll(product)
                },
                { onRetrieveDetailSuccessError() }
            )
    }

    fun getPurchased(): LiveData<String> {

        return purchased
    }

    private fun onRetrieveDetailFinishPurchased() {
        purchased.postValue("Purchased")
        Log.d("Test", "Already purchased")
    }

    private fun onRetrieveDetailSuccessError(){
        purchased.postValue("Already purchased")
        Log.d("Test", "Already purchased")//purchased.value = "Already purchased"
    }

    override fun onCleared() {
        super.onCleared()
        if (::subscription.isInitialized) subscription.dispose()
    }

}