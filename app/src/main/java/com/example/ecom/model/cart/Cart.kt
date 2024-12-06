package com.example.ecom.model.cart

import com.example.ecom.model.product.Product

data class Cart(
    val product : Product,
    val quantity : Int
)
