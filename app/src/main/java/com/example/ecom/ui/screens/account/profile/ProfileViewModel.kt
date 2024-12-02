package com.example.ecom.ui.screens.account.profile

import androidx.lifecycle.viewModelScope
import com.example.ecom.model.User
import com.example.ecom.model.product.FireStoreRepository
import com.example.ecom.model.service.AccountService
import com.example.ecom.ui.screens.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel
@Inject
constructor(
    private val accountService: AccountService,
    private val fireStoreRepository: FireStoreRepository
)  : AppViewModel()
{


}