package com.example.proyecto_biblioteca.navigation

sealed class Routes(val route: String) {

    object Inicio : Routes("inicio")
    object ListaLibros : Routes("lista_libros")
    object DetalleLibro : Routes("detalle_libro/{nombreLibro}") {
        fun createRoute(nombreLibro: String) = "detalle_libro/$nombreLibro"
    }
    object Confirmacion : Routes("confirmacion/{nombreLibro}") {
        fun createRoute(nombreLibro: String) = "confirmacion/$nombreLibro"
    }

    // Flujo 2: Mis Reservas
    object MisReservas : Routes("mis_reservas")

    object DetalleReserva : Routes("detalle_reserva/{nombreLibro}/{fecha}/{codigo}") {
        fun createRoute(nombreLibro: String, fecha: String, codigo: String): String {
            return "detalle_reserva/$nombreLibro/$fecha/$codigo"
        }
    }

    object RenovarReserva : Routes("renovar_reserva/{nombreLibro}/{fecha}") {
        fun createRoute(nombreLibro: String, fecha: String): String {
            return "renovar_reserva/$nombreLibro/$fecha"
        }
    }

    object RenovacionExitosa : Routes("renovacion_exitosa/{nombreLibro}/{fechaNueva}") {
        fun createRoute(nombreLibro: String, fechaNueva: String): String {
            return "renovacion_exitosa/$nombreLibro/$fechaNueva"
        }
    }
}