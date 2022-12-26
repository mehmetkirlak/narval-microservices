package com.narval.productservice.dto

data class CustomerDto @JvmOverloads constructor(
        val id: String? = null,
        val firstName:String,
        val lastName:String,
        val email:String,
        val phone:String
)