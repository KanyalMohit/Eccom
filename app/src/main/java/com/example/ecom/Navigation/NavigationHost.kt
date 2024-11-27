package com.example.ecom.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecom.model.service.AccountService
import com.example.ecom.ui.screens.authentication.login.LoginPage
import com.example.ecom.ui.screens.authentication.signUp.SignUpScreen
import com.example.ecom.ui.screens.home.HomeScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    accountService: AccountService,
    modifier: Modifier = Modifier,
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
            HomeScreen(navController = navController)
        }
        composable(Screen.LogIn.route){
            LoginPage(navController = navController)
        }
        composable(Screen.SignUp.route){
            SignUpScreen(navController = navController)
        }
    }
}