package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding // <-- Importación para usar el padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginapp.screens.LoginScreen
import com.example.loginapp.screens.SignUpScreen
import com.example.loginapp.ui.theme.LoginAppTheme
import com.example.loginapp.Destinations // <-- ¡IMPORTACIÓN NECESARIA!

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                MyAppNavigation()
            }
        }
    }
}

@Composable
fun MyAppNavigation() {
    // 1. Controlador de navegación que gestiona las transiciones entre pantallas
    val navController = rememberNavController()

    // 1. Scaffold proporciona el innerPadding
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        // 2. NavHost define el grafo de navegación
        NavHost(
            navController = navController,
            startDestination = Destinations.LOGIN_ROUTE, // La pantalla inicial es Login
            modifier = Modifier.padding(innerPadding) // <-- APLICA EL PADDING AQUÍ
        ) {
            // RUTA LOGIN
            composable(Destinations.LOGIN_ROUTE) {
                LoginScreen(
                    // Al LoginScreen le pasamos el NavController para que pueda navegar
                    onNavigateToSignUp = { navController.navigate(Destinations.SIGNUP_ROUTE) }
                )
            }

            // RUTA SIGNUP
            composable(Destinations.SIGNUP_ROUTE) {
                SignUpScreen(
                    // Al SignUpScreen le pasamos el NavController
                    onNavigateToLogin = { navController.navigate(Destinations.LOGIN_ROUTE) }
                )
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    LoginAppTheme {
        MyAppNavigation()
    }
}