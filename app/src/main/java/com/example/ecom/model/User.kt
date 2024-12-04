package com.example.ecom.model

data class User(
    val id: String = "",
    val email: String = "",
    val provider: String = "",
    val displayName: String = "",
    val isAnonymous: Boolean = false,
    val contactNumber: String = "",
    val address: String = "",
    val wishlist: List<Int> = emptyList(),
    val cart: Map<String, CartItem> = emptyMap()
)
data class CartItem(
    val productId: Int= 0,
    val quantity: Int = 0,
    val price: Int = 0
)
