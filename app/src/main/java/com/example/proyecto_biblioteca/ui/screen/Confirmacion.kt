package com.example.proyecto_biblioteca.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_biblioteca.navigation.Routes

@Composable
fun Confirmacion(navController: NavController, nombreLibro: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = "Éxito",
            tint = Color(0xFF4CAF50),
            modifier = Modifier.height(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Reserva Exitosa",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4CAF50)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Libro: $nombreLibro", fontSize = 18.sp)
        Text(text = "Fecha: 15/06/2026")

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            navController.navigate(Routes.Inicio.route) {
                popUpTo(Routes.Inicio.route) { inclusive = true }
            }
        }) {
            Text(text = "Volver al Inicio")
        }
    }
}