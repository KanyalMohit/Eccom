package com.example.ecom.model.product

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductRepository
@Inject
constructor(
    private val fireStore: FirebaseFirestore
)
{
    suspend fun getProduct() : List<Product>{
        val productList = mutableListOf<Product>()
        try {
            val result = fireStore.collection("Products").get().await()
            for(document  in result){
                val product = document.toObject(Product::class.java)
                productList.add(product)
            }
        }catch (e : Exception){
            Log.e("ProductRepository", "getProduct: ${e.localizedMessage}", e )
        }
        return  productList
    }
}