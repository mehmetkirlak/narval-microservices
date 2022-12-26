package com.narval.productservice.dto

data class ProductDto @JvmOverloads constructor(
        val id: String? = "",
        val name:String,
        val price:String
)