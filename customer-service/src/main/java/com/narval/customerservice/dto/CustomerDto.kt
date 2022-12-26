package com.narval.customerservice.dto

import com.narval.customerservice.model.Customer


data class CustomerDto @JvmOverloads constructor(
        val id: String? = null,
        val firstName:String,
        val lastName:String,
        val email:String,
        val phone:String
) {
    companion object {
        @JvmStatic
        fun convert(from: Customer): CustomerDto {
            return CustomerDto(
                    from.id?.let { CustomerIdDto.convert(it).customerId },
                    from.firstName,
                    from.lastName,
                    from.email,
                    from.phone
            )
        }
    }
}