package com.sehatqtestengineer.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sehatqtestengineer.model.Product
import com.sehatqtestengineer.model.ProductDao

@Database(entities = [(Product::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}