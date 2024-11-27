package com.example.ecom.ui.screens.authentication.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ecom.R
import kotlin.or

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()
    val confirmPassword = viewModel.confirmPassword.collectAsState()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.online_shopping),
                    contentDescription = "EcommLogo",
                    modifier = Modifier.padding(16.dp,4.dp)
                )
                Text(
                    text = "Create an account",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.padding(12.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 4.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .border(2.dp, Color(0xFF757575), RoundedCornerShape(20.dp)),
                    singleLine = true,
                    value = email.value,
                    onValueChange = { viewModel.updateEmail(it) },
                    placeholder = { Text("Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email"
                        )
                    }
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier =
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp, 4.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .border(2.dp, Color(0xFF757575), RoundedCornerShape(20.dp)),
                    value = password.value,
                    onValueChange = { viewModel.updatePassword(it) },
                    placeholder = { Text("Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Email",
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                )
                OutlinedTextField(
                    singleLine = true,
                    modifier =
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp, 4.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .border(2.dp, Color(0xFF757575) , RoundedCornerShape(20.dp)),
                    value = confirmPassword.value,
                    onValueChange = { viewModel.updateConfirmPassword(it) },
                    placeholder = { Text("Confirm password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Email",
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                )
                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "By clicking Sign Up, you agree to our Terms, Privacy Policy and Cookies Policy.",
                    fontSize = 12.sp,
                    color = Color(0xFF2A2929),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 20.dp),
                )

                Spacer(Modifier.padding(8.dp))

                Button(
                    onClick = { viewModel.onSignUpClick(navController) },
                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor =Color(0xFFFFAB00),
                        ),
                    modifier =
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp),
                ) {
                    Text(
                        text = "Sign up",
                        fontSize = 16.sp,
                        color = Color(0xFF1B1B1B),
                        modifier = modifier.padding(0.dp, 6.dp),
                    )
                }

                Spacer(Modifier.padding(4.dp))

                Text(
                    text = "or",
                    fontSize = 16.sp,
                    color = Color(0xFF0A0808),
                )

                Spacer(Modifier.padding(4.dp))

                Button(
                    onClick = {   },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA2E8EE)),
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google_g),
                        modifier = Modifier.padding(horizontal = 16.dp).size(35.dp),
                        contentDescription = "Google logo",
                    )
                    Text(
                        text = "Sign in with Google",
                        color = Color(0xFF1B1B1B) ,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(0.dp, 6.dp),
                    )
                }

            }
        }
    }

}


