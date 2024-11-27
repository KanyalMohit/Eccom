package com.example.ecom.ui.screens.authentication.signUp

import android.util.Log
import androidx.navigation.NavController
import com.example.ecom.Navigation.Screen
import com.example.ecom.model.service.AccountService
import com.example.ecom.ui.screens.AppViewModel
import com.example.ecom.ui.screens.authentication.isValidEmail
import com.example.ecom.ui.screens.authentication.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel

@Inject
constructor(
    private val accountService: AccountService
) : AppViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password : StateFlow<String> = _password.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword : StateFlow<String> = _confirmPassword.asStateFlow()

    fun updateEmail(newEmail : String) {
        _email.value = newEmail
    }
    fun updatePassword(newPassword : String){
        _password.value = newPassword
    }
    fun updateConfirmPassword(newConfirmPassword : String){
        _confirmPassword.value = newConfirmPassword
    }

    fun onSignUpClick(navController: NavController){
        launchCatching{
            if(!_email.value.isValidEmail()){
                throw IllegalArgumentException("Invalid Email Format")
            }
            if(!_password.value.isValidPassword()){
                throw IllegalArgumentException("Invalid Password Format")
            }
            if(_password.value != _confirmPassword.value){
                throw IllegalArgumentException("Passwords do not match")
            }
            try{
                accountService.linkAccountWithEmail(_email.value,_password.value)
            }catch(e : Exception){
                Log.e("SignupModel", "onSignUpClick: ${e.localizedMessage}", e )
            }

            navController.navigate(Screen.LogIn.route){
                launchSingleTop = true
            }
        }
    }

}