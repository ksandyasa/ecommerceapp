package com.sehatqtestengineer.viewmodel

import androidx.lifecycle.ViewModel
import com.sehatqtestengineer.di.component.DaggerViewModelInjector
import com.sehatqtestengineer.di.component.ViewModelInjector
import com.sehatqtestengineer.di.module.NetworkModule

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is LoginViewModel -> injector.inject(this)
            is HomeViewModel -> injector.inject(this)
            is ProductViewModel -> injector.inject(this)
            is CategoryViewModel -> injector.inject(this)
        }
    }

}