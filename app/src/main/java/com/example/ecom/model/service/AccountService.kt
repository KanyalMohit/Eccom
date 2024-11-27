package com.example.ecom.model.service

import com.example.ecom.model.User
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser : Flow<User?>
    val currentUserId : String

    fun hasUser() : Boolean

    fun getUserProfile() : User

    suspend fun createAnonymousAccount()

    suspend fun updateDisplayName(newDisplayName : String)

    suspend fun signInWithGoogle(idToken : String)

    suspend fun  signInWithEmail(email : String , password : String)

    suspend fun linkAccountWithEmail(
        email: String,
        password: String
    )

    suspend fun deleteAccount()

    suspend fun signOut()

}