package com.sehatqtestengineer.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @get:Query("SELECT * FROM product")
    val all: List<Product>

    @Insert
    fun insertAll(vararg product: Product)

}