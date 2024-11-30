package com.example.ecom.Navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ecom.model.service.AccountService
import com.example.ecom.ui.screens.authentication.login.LoginPage
import com.example.ecom.ui.screens.authentication.signUp.SignUpScreen
import com.example.ecom.ui.screens.home.HomeScreen
import com.example.ecom.ui.screens.SharedViewModel
import com.example.ecom.ui.screens.productDetail.DetailPage

@Composable
fun NavigationHost(
    navController: NavHostController,
    accountService: AccountService,
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel
) {
    val startDestination =
        when{
            !accountService.hasUser() -> Screen.LogIn.route
            accountService.getUserProfile().isAnonymous -> Screen.SignUp.route
            else -> Screen.Home.route
        }
    NavHost(
        navController =  navController,
        startDestination = startDestination,
        modifier = modifier
    ){
        composable(Screen.Home.route){
            HomeScreen(navController = navController,sharedViewModel)
        }
        composable(Screen.LogIn.route){
            LoginPage(navController = navController)
        }
        composable(Screen.SignUp.route){
            SignUpScreen(navController = navController)
        }
        composable(
            Screen.DetailPage.route + "/{productId}",
            arguments = listOf(navArgument("productId"){})
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            val id = productId?.toInt()
            Log.d("DetailPage", "productId: $productId")
            DetailPage(
                navController = navController,
                productId = id,
                sharedViewModel = sharedViewModel
            )
        }
    }
}