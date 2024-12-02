package com.example.ecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.ecom.Navigation.NavigationHost
import com.example.ecom.model.product.FireStoreRepository
import com.example.ecom.model.service.AccountServiceImpl
import com.example.ecom.ui.screens.SharedViewModel
import com.example.ecom.ui.theme.EcomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   // private val firestore = FirebaseFirestore.getInstance()
   private val sharedViewModel: SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcomTheme {
                EcomApp(sharedViewModel = sharedViewModel)
            }
        }
        //uploadProduct(products = products)
    }
    /*private fun uploadProduct(products : List<Product>){
        var i = 0
        val collection = firestore.collection("Products")
        products.forEach{ product ->
            collection.document(i.toString())
                .set(product)
                .addOnSuccessListener {
                    Log.d("Firebase", "Product uploaded successfully with ID $i")
                }
                .addOnFailureListener { e ->
                    Log.e("Firebase", "Failed to upload product", e)
                }
            i++
        }
    }*/
}


@Composable
fun EcomApp(sharedViewModel: SharedViewModel) {
    val navController = rememberNavController()
    val accountService = remember { AccountServiceImpl(fireStoreRepository = FireStoreRepository()) }
    NavigationHost(navController,accountService = accountService, sharedViewModel = sharedViewModel)
}

