package com.example.proyecto_biblioteca.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun DetalleLibro(navController: NavController, nombreLibro: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Detalle del Libro",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Parámetro recibido",
            color = Color(0xFFD97706),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Nombre: $nombreLibro", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Autor: Robert C. Martin")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Categoría: Programación")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Descripción:\nGuía práctica para escribir código limpio, legible y mantenible.")
        }


        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate(Routes.Confirmacion.createRoute(nombreLibro))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Reservar Libro")
        }
    }
}