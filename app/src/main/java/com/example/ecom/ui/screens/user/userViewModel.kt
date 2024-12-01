package com.example.ecom.ui.screens.user

import androidx.lifecycle.viewModelScope
import com.example.ecom.model.User
import com.example.ecom.model.product.FireStoreRepository
import com.example.ecom.model.service.AccountService
import com.example.ecom.ui.screens.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val accountService: AccountService,
    private val firestoreRepository: FireStoreRepository
) : AppViewModel() {

    val currentUser = accountService.currentUser

    fun updateDisplayName(newDisplayName: String) {
        viewModelScope.launch {
            accountService.updateDisplayName(newDisplayName)
            // Update in Firestore
            firestoreRepository.updateUser(accountService.currentUserId, mapOf("displayName" to newDisplayName))
        }
    }

    fun updateUserProfile(contact: String, address: String) {
        viewModelScope.launch {
            firestoreRepository.updateUser(
                accountService.currentUserId,
                mapOf(
                    "contactNumber" to contact,
                    "address" to address
                )
            )
        }
    }

    fun saveUser(user: User) {
        viewModelScope.launch {
            firestoreRepository.saveUser(user)
        }
    }

    suspend fun fetchUser(): User? {
        return firestoreRepository.getUser(accountService.currentUserId)
    }
}
