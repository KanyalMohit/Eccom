package com.example.ecom.ui.screens.productDetail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.ecom.model.cart.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.ecom.model.product.Product
import com.example.ecom.model.service.AccountServiceImpl
import com.example.ecom.ui.screens.AppViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel
    @Inject
    constructor(
        private val cartRepository: CartRepository,
        private val accountService: AccountServiceImpl
    )
    : AppViewModel(){

        private val userId = accountService.currentUserId

    fun getProductById(productId: Int, products: List<Product>): Product? {
        for (product in products) {
            if (product.stock == productId) { // Use product.id for comparison
                return product
            }
        }
        return null
    }

    fun addToCart(productId: Int?, quantity: Int) {
        viewModelScope.launch{
            try {
                if (productId!=null)cartRepository.addToCart(userId,productId,quantity)
                Log.d("addToCart", "addToCart: Added product ")
            }catch (e : Exception){
                Log.d("error", "addToCart: $e")
            }
        }
    }

}