package com.example.ecom.ui.screens.cart

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import com.example.ecom.model.cart.Cart
import com.example.ecom.model.cart.CartRepository
import com.example.ecom.model.product.Product
import com.example.ecom.model.service.AccountService
import com.example.ecom.ui.screens.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class CartViewModel
@Inject
constructor(
    private val cartRepository: CartRepository,
    private val accountService: AccountService,
)
    : AppViewModel()
{
    private val _cartItem: MutableStateFlow<List<Map<String, Any>>> = MutableStateFlow(emptyList())
    private val userId = accountService.currentUserId
    private val _cartItems = MutableStateFlow<List<Cart>>(emptyList())
    private val _cartQuantity = MutableStateFlow<List<Int>>(emptyList())
    val cartItems = _cartItems
    val cartQuantity = _cartQuantity

    init {
        fetchCart()
        getProductsInCart(emptyList())
    }
    fun fetchCart(userUid: String = accountService.currentUserId){
        viewModelScope.launch {
            try {
                val items = cartRepository.fetchCart(userUid)
                _cartItem.value = items
                Log.d("CartViewModel", "fetchCart: $items")
            }catch (e : Exception){
                Log.d("error", "fetchCart: $e")
            }
        }
    }

    fun removeCart(productId: Int){
        viewModelScope.launch{
            try {
                cartRepository.removeFromCart(userId,productId)
            }catch (e : Exception){
                Log.d("CartViewModel", "removeCart: $e")
            }
        }
    }

    fun getProductsInCart(products: List<Product>) {
        val cartProductIds = _cartItem.value.mapNotNull {
            (it["productId"] as? Long)?.toInt()
        }
        val cartQuantities = _cartItem.value.mapNotNull {
            (it["quantity"] as? Long)?.toInt()
        }

        _cartItems.value = products.filter { product ->
            cartProductIds.contains(product.stock)
        }.mapIndexed { index, product ->
            Cart(product, cartQuantities[index])
        }

    }

    fun getCartItemCount(): Int {
        return _cartItem.value.sumOf { (it["quantity"] as? Int) ?: 0 }
    }

}