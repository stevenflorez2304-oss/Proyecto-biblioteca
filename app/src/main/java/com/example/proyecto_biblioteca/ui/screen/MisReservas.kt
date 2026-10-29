package com.example.proyecto_biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto_biblioteca.navigation.Routes

data class ReservaItem(
    val titulo: String,
    val fecha: String,
    val codigo: String,
    val estado: String
)

// Estado global reactivo
object EstadoReservas {
    val lista = mutableStateListOf(
        ReservaItem("Clean Code", "15-06-2026", "RES-2026-001", "Activa"),
        ReservaItem("Kotlin para Android", "18-06-2026", "RES-2026-002", "Activa"),
        ReservaItem("Arquitectura de Software", "22-06-2026", "RES-2026-003", "Pendiente")
    )
}

@Composable
fun MisReservas(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mis Reservas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Lista de tus reservas activas",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(EstadoReservas.lista, key = { it.codigo }) { reserva ->
                TarjetaReserva(reserva = reserva, navController = navController)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8EAF6), RoundedCornerShape(8.dp))
                .padding(12.dp)
        ) {
            Text(
                text = "ⓘ Selecciona 'Ver Reserva' para gestionar una reserva.",
                fontSize = 12.sp,
                color = Color(0xFF3F51B5)
            )
        }
    }
}

@Composable
fun TarjetaReserva(reserva: ReservaItem, navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(50.dp, 70.dp)
                        .background(Color.DarkGray, RoundedCornerShape(4.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = reserva.titulo.take(5),
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(text = "Libro: ${reserva.titulo}", fontWeight = FontWeight.Bold)
                    Text(text = "Fecha: ${reserva.fecha}")
                    Spacer(modifier = Modifier.height(4.dp))

                    Box(
                        modifier = Modifier
                            .background(
                                if (reserva.estado == "Activa") Color(0xFFE8F5E9) else Color(0xFFFFF3E0),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 10.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = reserva.estado,
                            color = if (reserva.estado == "Activa") Color(0xFF2E7D32) else Color(0xFFE65100),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    navController.navigate(
                        Routes.DetalleReserva.createRoute(
                            nombreLibro = reserva.titulo,
                            fecha = reserva.fecha,
                            codigo = reserva.codigo
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Ver Reserva")
            }
        }
    }
}