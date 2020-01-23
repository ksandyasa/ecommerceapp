package com.sehatqtestengineer.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.sehatqtestengineer.model.database.AppDatabase
import com.sehatqtestengineer.viewmodel.DetailViewModel
import com.sehatqtestengineer.viewmodel.PurchaseViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            val db = Room.databaseBuilder(context, AppDatabase::class.java, "product").build()

            return DetailViewModel(db.productDao()) as T
        } else if (modelClass.isAssignableFrom(PurchaseViewModel::class.java)) {
            val db = Room.databaseBuilder(context, AppDatabase::class.java, "product").build()

            return PurchaseViewModel(db.productDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}