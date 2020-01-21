package com.sehatqtestengineer.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sehatqtestengineer.model.Category

class CategoryViewModel: BaseViewModel() {

    private val categoryName = MutableLiveData<String>()
    private val categoryImageUrl = MutableLiveData<String>()

    fun bind(category: Category) {
        categoryName.value = category.name
        categoryImageUrl.value = category.imageUrl
    }

    fun getCategoryName(): MutableLiveData<String> {

        return categoryName
    }

    fun getCategoryImageUrl(): MutableLiveData<String> {

        return categoryImageUrl
    }

}