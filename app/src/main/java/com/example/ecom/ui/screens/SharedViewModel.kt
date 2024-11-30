package com.example.ecom.ui.screens

import androidx.lifecycle.viewModelScope
import com.example.ecom.model.product.Product
import com.example.ecom.model.product.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
@Inject
constructor(
    private val productRepository: ProductRepository
) : AppViewModel(){
    private val _product = MutableStateFlow<List<Product>>(emptyList())
    val product : StateFlow<List<Product>> get() = _product

    init {
        fetchProduct()
    }
    fun fetchProduct(){
        viewModelScope.launch {
            try {
                val fetchedProducts = productRepository.getProduct()
                _product.value = fetchedProducts.shuffled()
            }catch (e : Exception){

            }
        }
    }
}