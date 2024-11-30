package com.example.ecom.ui.screens.productDetail

import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.ecom.model.product.Product
import com.example.ecom.ui.screens.AppViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel
    @Inject
    constructor()
    : AppViewModel(){

    fun getProductById(productId: Int, products: List<Product>): Product? {
        for (product in products) {
            if (product.stock == productId) { // Use product.id for comparison
                return product
            }
        }
        return null
    }

}