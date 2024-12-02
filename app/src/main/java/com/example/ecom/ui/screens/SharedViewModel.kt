package com.example.ecom.ui.screens

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.ecom.model.User
import com.example.ecom.model.product.FireStoreRepository
import com.example.ecom.model.product.Product
import com.example.ecom.model.product.ProductRepository
import com.example.ecom.model.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
@Inject
constructor(
    private val productRepository: ProductRepository,
    private val accountService: AccountService,
    private val fireStoreRepository: FireStoreRepository
) : AppViewModel(){
    private val _product = MutableStateFlow<List<Product>>(emptyList())
    val product : StateFlow<List<Product>> get() = _product

    init {
        fetchProduct()
        fetchUserProfile()
    }
    fun fetchProduct(){
        viewModelScope.launch {
            try {
                val fetchedProducts = productRepository.getProduct()
                _product.value = fetchedProducts.shuffled()
            }catch (e : Exception){
                Log.d("StartFetch", "fetchProduct: $e")
            }
        }
    }
    private val _user = MutableStateFlow<User?>(null)
    val user : StateFlow<User?> = _user

    private fun fetchUserProfile(){
        viewModelScope.launch{
            val userId = accountService.currentUserId
            if (userId.isNotEmpty()){
                val userProfile = fireStoreRepository.getUser(userId)
                _user.value = userProfile
            }
        }
    }

    fun updateProfile(updates : Map<String, Any>) {
        viewModelScope.launch{
            val userId = accountService.currentUserId
            if (userId.isNotEmpty()){

                Log.d("UpdateProfielData", "updateProfile: ")
                fireStoreRepository.updateUser(userId,updates)
                fetchUserProfile()
            }
        }
    }

}