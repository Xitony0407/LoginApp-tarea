package com.example.loginapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf // <-- ¡NUEVA IMPORTACIÓN!
import androidx.compose.runtime.remember // <-- ¡NUEVA IMPORTACIÓN!
import androidx.compose.runtime.setValue // <-- ¡NUEVA IMPORTACIÓN!
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.Blanco
import com.example.loginapp.ui.theme.LoginAppTheme
import com.example.loginapp.ui.theme.Negro // Asegúrate de que este color Negro sea un color oscuro
import androidx.compose.foundation.clickable // <-- NUEVA IMPORTACIÓN
import androidx.compose.ui.text.input.PasswordVisualTransformation // Para ocultar la contraseña



@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onNavigateToSignUp : () -> Unit
) {
    // Definición de estados para los campos de texto
    var emailValue by remember { mutableStateOf("") } // Estado para Email
    var passwordValue by remember { mutableStateOf("") } // Estado para Contraseña

    //FONDO
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0)) //
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp) //
        ) {

            //CUADRO NEGRO
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Negro),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.
                    padding(top = 60.dp)
                ) {

                    //CUADRO BLANCO (LOGO)
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(Blanco, RoundedCornerShape(10.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }


        //CUADRO BLANCO
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 70.dp,
                            topEnd = 0.dp,
                            bottomStart = 70.dp,
                            bottomEnd = 70.dp
                        )
                    )
                    .background(Blanco)
                    .padding(horizontal = 30.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                //LOGIN
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Login",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Negro
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    //EMAIL
                    TextField(
                        value = emailValue, // <-- Usa el estado
                        onValueChange = { emailValue = it }, // <-- ¡Actualiza el estado!
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    //CONTRASEÑA
                    TextField(
                        value = passwordValue, // <-- Usa el estado
                        onValueChange = { passwordValue = it }, // <-- ¡Actualiza el estado!
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(), // <-- Oculta la contraseña
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    //BOTON
                    Button(
                        onClick = onNavigateToSignUp, // <-- ACCIÓN: Ir a SignUp
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Negro)
                    ) {
                        Text("Login", color = Blanco, fontSize = 18.sp)
                    }
                }

                //SIGN UP
                Text(
                    text = "¿Don't have any account? Sign Up",
                    color = Negro,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clickable(onClick = onNavigateToSignUp) // <-- ACCIÓN: Ir a SignUp
                )
            }
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginAppTheme {
        LoginScreen(onNavigateToSignUp = {})
    }
}