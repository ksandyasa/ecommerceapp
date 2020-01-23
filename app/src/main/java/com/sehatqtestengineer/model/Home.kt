package com.sehatqtestengineer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class Home(val data: Data)

data class Data(val category: List<Category>, val productPromo: List<Product>)

data class Category(val imageUrl: String, val id: Int, val name: String)

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "loved") val loved: Int
): Serializable