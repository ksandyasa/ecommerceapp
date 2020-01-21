package com.sehatqtestengineer.viewmodel

import androidx.lifecycle.ViewModel
import com.sehatqtestengineer.di.component.DaggerViewModelInjector
import com.sehatqtestengineer.di.component.ViewModelInjector
import com.sehatqtestengineer.di.module.NetworkModule
import com.sehatqtestengineer.viewmodel.HomeViewModel
import com.sehatqtestengineer.viewmodel.ProductViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is HomeViewModel -> injector.inject(this)
            is ProductViewModel -> injector.inject(this)
            is CategoryViewModel -> injector.inject(this)
        }
    }

}