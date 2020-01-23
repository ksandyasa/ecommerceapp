package com.sehatqtestengineer.di.component

import com.sehatqtestengineer.di.module.NetworkModule
import com.sehatqtestengineer.viewmodel.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(loginViewModel: LoginViewModel)
    fun inject(homeViewModel: HomeViewModel)
    fun inject(productViewModel: ProductViewModel)
    fun inject(categoryViewModel: CategoryViewModel)
    fun inject(detailViewModel: DetailViewModel)
    fun inject(purchaseViewModel: PurchaseViewModel)
    fun inject(purchaseListViewModel: PurchaseListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}