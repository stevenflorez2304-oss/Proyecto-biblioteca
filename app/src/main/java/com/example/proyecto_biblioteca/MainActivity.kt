package com.example.proyecto_biblioteca
import androidx.compose.foundation.layout.safeDrawingPadding
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import com.example.proyecto_biblioteca.navigation.AppNavigation
import com.example.proyecto_biblioteca.ui.theme.ProyectobibliotecaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectobibliotecaTheme {

                Surface(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
                    AppNavigation()
                }
            }
        }
    }
}