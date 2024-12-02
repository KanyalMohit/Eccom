package com.example.ecom.model.product

import android.util.Log
import com.example.ecom.model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FireStoreRepository
@Inject
constructor() {
    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")

    suspend fun saveUser(user: User) {
        usersCollection.document(user.id).set(user).await()
    }

    suspend fun getUser(uid: String): User? {
        val documentSnapshot = usersCollection.document(uid).get().await()
        return if (documentSnapshot.exists()) documentSnapshot.toObject(User::class.java) else null
    }

    suspend fun updateUser(uid: String, updates: Map<String, Any>) {
        try {
            usersCollection.document(uid).update(updates).await()
            Log.d("update", "updateUser: Succesfull")
        }catch (e : Exception){
            Log.d("update", "updateUser: $e ")
        }
    }

    suspend fun userExists(uid: String): Boolean {
        val documentSnapshot = usersCollection.document(uid).get().await()
        return documentSnapshot.exists()
    }
}