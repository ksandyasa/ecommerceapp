package com.sehatqtestengineer.di.component

import com.sehatqtestengineer.di.module.NetworkModule
import com.sehatqtestengineer.viewmodel.CategoryViewModel
import com.sehatqtestengineer.viewmodel.HomeViewModel
import com.sehatqtestengineer.viewmodel.ProductViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(homeViewModel: HomeViewModel)
    fun inject(productViewModel: ProductViewModel)
    fun inject(categoryViewModel: CategoryViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}