package com.example.ecom.Navigation

sealed class Screen(
    val route : String,
) {
    data object  SignUp : Screen("sign_up")
    data object  LogIn : Screen("LogIn")
    data object  Home : Screen("home")
    data object  Cart : Screen("cart")
    data object  Profile : Screen("profile")
    data object  DetailPage : Screen("detailPage")
}