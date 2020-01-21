package com.sehatqtestengineer.viewmodel

import android.util.Log
import com.sehatqtestengineer.api.RestApi
import com.sehatqtestengineer.features.adapters.CategoryAdapter
import com.sehatqtestengineer.features.adapters.ProductAdapter
import com.sehatqtestengineer.model.Data
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel: BaseViewModel() {

    @Inject
    lateinit var restApi: RestApi

    private lateinit var subscription: Disposable

    val productAdapter: ProductAdapter = ProductAdapter()
    val categoryAdapter: CategoryAdapter = CategoryAdapter()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        subscription = restApi.getHomeData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{ onRetrieveHomeStart() }
            .doOnTerminate { onRetrieveHomeFinish() }
            .subscribe(
                { result -> onRetrieveHomeSuccess(result[0].data) },
                { onRetrieveHomeSuccessError()}
                )
    }

    private fun onRetrieveHomeStart() {

    }

    private fun onRetrieveHomeFinish() {

    }

    private fun onRetrieveHomeSuccess(data: Data) {
        Log.d("Test", "size product: " + data.productPromo.size)
        Log.d("Test", "size category:" + data.category.size)
        productAdapter.updateProductList(data.productPromo)
        categoryAdapter.updateCategoryList(data.category)
    }

    private fun onRetrieveHomeSuccessError(){

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}