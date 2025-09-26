package com.example.loginapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // <-- IMPORTACIÓN
import androidx.compose.runtime.mutableStateOf // <-- IMPORTACIÓN
import androidx.compose.runtime.remember // <-- IMPORTACIÓN
import androidx.compose.runtime.setValue // <-- IMPORTACIÓN
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation // <-- ¡NUEVA! Para ocultar la contraseña
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.Blanco
import com.example.loginapp.ui.theme.LoginAppTheme
import com.example.loginapp.ui.theme.Negro // Asegúrate de que este color Negro sea un color oscuro
import androidx.compose.foundation.clickable // <-- NUEVA IMPORTACIÓN


@Composable
fun SignUpScreen(
    onNavigateToLogin: () -> Unit // <-- NUEVO PARÁMETRO: Función para ir a Login
) {
    // Definición de estados para todos los campos de texto
    var firstNameValue by remember { mutableStateOf("") }
    var lastNameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") } // Valor inicial con puntos
    var confirmPasswordValue by remember { mutableStateOf("") } // Valor inicial con puntos

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0)) // Gris claro para el fondo externo
    ) {
        // 2. Columna que contiene la estructura vertical
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 40.dp)
        ) {

            // 3. Parte superior oscura con el Back Button y Título
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f) // Ocupa un 30% del alto disponible (menos que en Login)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Negro), // Color oscuro principal
                contentAlignment = Alignment.TopStart
            ) {
                // Contenido de la barra superior oscura
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Flecha de retroceso
                    IconButton(onClick = onNavigateToLogin) { // <-- ACCIÓN: Ir a Login
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go back",
                            tint = Blanco
                        )
                    }
                    // Título "Sign Up" centrado
                    Box(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Sign Up",
                            color = Blanco,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(end = 40.dp) // Offset para centrar junto al icono
                        )
                    }
                }
            }

            // Espacio para la superposición
            Spacer(modifier = Modifier.weight(1f))
        }

        // 4. La Tarjeta Blanca de Sign Up (Superpuesta)
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter // Alinea el contenido al fondo
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f) // Ocupa un 85% del alto (más que Login por más campos)
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
                verticalArrangement = Arrangement.SpaceBetween // Distribuye el espacio entre los elementos
            ) {
                // Contenido de la tarjeta de Sign Up
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Spacer para compensar el título y empujar los campos hacia abajo
                    Spacer(modifier = Modifier.height(20.dp))

                    // Campo: Nombre
                    TextField(
                        value = firstNameValue,
                        onValueChange = { firstNameValue = it }, // HACE EDITABLE
                        label = { Text("First name") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // Campo: Apellido
                    TextField(
                        value = lastNameValue,
                        onValueChange = { lastNameValue = it }, // HACE EDITABLE
                        label = { Text("Last name") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // Campo: Email
                    TextField(
                        value = emailValue,
                        onValueChange = { emailValue = it }, // HACE EDITABLE
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // Campo: Contraseña (OCULTA)
                    TextField(
                        value = passwordValue,
                        onValueChange = { passwordValue = it }, // HACE EDITABLE
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(), // <-- ¡OCULTA EL TEXTO!
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    // Campo: Confirmar Contraseña (OCULTA)
                    TextField(
                        value = confirmPasswordValue,
                        onValueChange = { confirmPasswordValue = it }, // HACE EDITABLE
                        label = { Text("Confirm password") },
                        visualTransformation = PasswordVisualTransformation(), // <-- ¡OCULTA EL TEXTO!
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    // Botón de Sign Up
                    Button(
                        onClick = onNavigateToLogin, // <-- ACCIÓN: Ir a Login
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Negro)
                    ) {
                        Text("Sign Up", color = Blanco, fontSize = 18.sp)
                    }
                }

                // Enlace 'Sign In'
                Text(
                    text = "Already have any account? Sign In",
                    color = Negro,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clickable(onClick = onNavigateToLogin) // <-- ACCIÓN: Ir a Login
                )
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    LoginAppTheme {
        SignUpScreen(onNavigateToLogin = {})
    }
}