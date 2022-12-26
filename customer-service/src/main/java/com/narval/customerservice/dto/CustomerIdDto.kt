package com.narval.customerservice.dto

data class CustomerIdDto @JvmOverloads constructor(
        val customerId: String? = ""
) {
    companion object {
        @JvmStatic
        fun convert(id: String): CustomerIdDto {
            return CustomerIdDto(id)
        }
    }
}