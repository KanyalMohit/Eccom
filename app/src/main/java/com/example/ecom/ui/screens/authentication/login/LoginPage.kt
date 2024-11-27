package com.example.ecom.ui.screens.authentication.login
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.ButtonDefaults.outlinedButtonBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ecom.Navigation.Screen
import com.example.ecom.R


@Composable
fun LoginPage(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: LogInViewModel = hiltViewModel()
) {
    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()

    Scaffold { it->
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier =
                    Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.online_shopping),
                    contentDescription = "Auth image",
                    modifier =
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp, 4.dp),
                )
                Text(
                    text = "Log in to your account",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF070707),
                    textAlign = TextAlign.Center,
                )

                Spacer(Modifier.padding(12.dp))

                OutlinedTextField(
                    singleLine = true,
                    modifier =
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp, 4.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .border(2.dp, Color(0xFF000000), RoundedCornerShape(20.dp)),
                    value = email.value,
                    onValueChange = { viewModel.updateEmail(it) },
                    placeholder = { Text("Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email",
                        )
                    },
                )

                OutlinedTextField(
                    singleLine = true,
                    modifier =
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp, 4.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .border(2.dp, Color(0xFF000000), RoundedCornerShape(20.dp)),
                    value = password.value,
                    onValueChange = { viewModel.updatePassword(it) },
                    placeholder = { Text("Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password",
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                )

                Spacer(Modifier.padding(12.dp))

                Button(
                    onClick = { viewModel.onSignInClick(navController) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFBA800)),
                    modifier =
                        modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp),
                ) {
                    Text(
                        text = "Sign in",
                        fontSize = 16.sp,
                        color =Color(0xFF1B1B1B),
                        modifier = modifier.padding(0.dp, 6.dp),
                    )
                }

                Spacer(Modifier.padding(4.dp))

                Text(text = "or", fontSize = 16.sp, color = Color(0xFF050505))

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


                Spacer(Modifier.padding(8.dp))
                TextButton(
                    onClick = { navController.navigate(Screen.SignUp.route) },
                    modifier = Modifier.padding(horizontal = 16.dp),
                ) {
                    Text(
                        text = "Don't have an account? Click here to sign up!",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF1D0101),
                    )
                }
            }
        }
    }

}




