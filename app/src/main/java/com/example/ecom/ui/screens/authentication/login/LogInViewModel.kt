package com.example.ecom.ui.screens.authentication.login

import androidx.navigation.NavController
import com.example.ecom.Navigation.Screen
import com.example.ecom.model.service.AccountService
import com.example.ecom.ui.screens.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LogInViewModel
@Inject
constructor(
    private val accountService : AccountService,
) : AppViewModel()
{
    private val _email = MutableStateFlow("")
    val email : StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password : StateFlow<String> = _password.asStateFlow()

    fun updateEmail(newEmail : String){
        _email.value = newEmail
    }
    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }
    fun onSignInClick(navController: NavController){
        launchCatching{
            accountService.signInWithEmail(_email.value, _password.value)
            navController.navigate(Screen.Home.route){
                launchSingleTop = true
            }
        }
    }

}