package com.example.ecom.model.cart

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class CartRepository
@Inject
constructor(
    private val fireStore : FirebaseFirestore
)
{
    private val usersCollection = fireStore.collection("users")

    suspend fun addToCart(userId: String, productId: Int, quantity : Int) {
        val cartItem  = mapOf(
            "productId" to productId,
            "quantity" to quantity
        )
        usersCollection.document(userId)
            .collection("cart")
            .document(productId.toString())
            .set(cartItem).await()
    }

    suspend fun removeFromCart(userId : String , productId : Int): List<Map<String, Any>> {
        val snapshot = usersCollection.document(userId)
            .collection("cart")
            .get()
            .await()

        return snapshot.documents.map { it -> it.data ?: emptyMap() }

    }

    suspend fun fetchCart(userId: String) : List<Map<String, Any>>{
        val snapshot = usersCollection.document(userId)
            .collection("cart")
            .get()
            .await()
        return snapshot.documents.map { it -> it.data ?: emptyMap()  }
    }
}