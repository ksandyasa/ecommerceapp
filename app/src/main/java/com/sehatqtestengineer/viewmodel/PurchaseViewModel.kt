package com.sehatqtestengineer.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.sehatqtestengineer.features.adapters.PurchaseAdapter
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.model.ProductDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PurchaseViewModel(private val productDao: ProductDao): BaseViewModel() {

    private lateinit var subscription: Disposable

    val purchaseAdapter: PurchaseAdapter = PurchaseAdapter()

    init {
        loadPurchaseData()
    }

    private fun loadPurchaseData() {
        subscription = Observable.fromCallable { productDao.all }
            .concatMap {dbProductList ->
                Observable.just(dbProductList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePurchaseStart() }
            .doOnTerminate { onRetrievePurchaseFinish() }
            .subscribe(
                { result -> onRetrievePurchaseSuccess(result) },
                { onRetrievePurchaseSuccessError()   }
            )
    }

    private fun onRetrievePurchaseStart() {

    }

    private fun onRetrievePurchaseFinish() {

    }

    private fun onRetrievePurchaseSuccess(list: List<Product>) {
        purchaseAdapter.updatePurchaseList(list)
    }

    private fun onRetrievePurchaseSuccessError(){

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }


}