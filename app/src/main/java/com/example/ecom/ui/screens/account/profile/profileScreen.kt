package com.example.ecom.ui.screens.account.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ecom.model.User
import com.example.ecom.ui.screens.SharedViewModel
import com.example.ecom.ui.screens.home.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    val user = sharedViewModel.user.value ?: User()
    var name = remember {
        mutableStateOf( user.displayName )
    }
    var email = user.email

    var phone = remember {
        mutableStateOf(user.contactNumber)
    }
    var address = remember {
        mutableStateOf(user.address)
    }
    if (email.isEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }else{
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "My Details") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigateUp()
                        }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = {

                        }) {
                            Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
                )
            },
            containerColor = Color.White,
            bottomBar = {
                BottomNavigationBar(navController = navController)
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Full Name Field
                TextFieldWithLabel(
                    label = "Full Name",
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    }
                )

                // Email Address Field
                TextFieldWithLabel(
                    label = "Email Address",
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    keyboardType = KeyboardType.Email,
                    readOnly = true
                )

                // Phone Number Field
                TextFieldWithLabel(
                    label = "Phone Number",
                    value = phone.value,
                    onValueChange = {
                        phone.value =it
                    },
                    keyboardType = KeyboardType.Phone
                )
                TextFieldWithLabel(
                    label = "Address",
                    value = address.value,
                    onValueChange = {
                        address.value = it
                    }
                )

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = {
                        sharedViewModel.updateProfile(mapOf(
                            "displayName" to name.value,
                            "contactNumber" to phone.value,
                            "address" to address.value
                        ))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB18202)
                    )
                ) {
                    Text("Submit")
                }
            }
        }
    }
}


@Composable
fun TextFieldWithLabel(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    trailingIcon: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = label, style = MaterialTheme.typography.labelMedium, color = Color.Black)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange ,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = trailingIcon,
            readOnly = readOnly
        )
    }
}