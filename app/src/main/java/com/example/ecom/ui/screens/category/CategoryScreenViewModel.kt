package com.example.ecom.ui.screens.category


import com.example.ecom.model.product.Product
import com.example.ecom.ui.screens.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CategoryScreenViewModel
@Inject
constructor() : AppViewModel(){

    fun filterProducts(productsToShow: String, products: List<Product>): List<Product> {
        return products.filter { it.category == productsToShow }
    }

}