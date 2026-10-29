package com.example.proyecto_biblioteca.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyecto_biblioteca.ui.screen.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Inicio.route) {


        composable(Routes.Inicio.route) { Inicio(navController) }
        composable(Routes.ListaLibros.route) { ListaLibros(navController) }

        composable(
            route = Routes.DetalleLibro.route,
            arguments = listOf(navArgument("nombreLibro") { type = NavType.StringType })
        ) { backStackEntry ->
            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            DetalleLibro(navController, nombreLibro)
        }

        composable(
            route = Routes.Confirmacion.route,
            arguments = listOf(navArgument("nombreLibro") { type = NavType.StringType })
        ) { backStackEntry ->
            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            Confirmacion(navController, nombreLibro)
        }


        composable(Routes.MisReservas.route) {
            MisReservas(navController)
        }


        composable(
            route = Routes.DetalleReserva.route,
            arguments = listOf(
                navArgument("nombreLibro") { type = NavType.StringType },
                navArgument("fecha") { type = NavType.StringType },
                navArgument("codigo") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            val fecha = backStackEntry.arguments?.getString("fecha") ?: ""
            val codigo = backStackEntry.arguments?.getString("codigo") ?: ""

            DetalleReserva(navController, nombreLibro, fecha, codigo)
        }


        composable(
            route = Routes.RenovarReserva.route,
            arguments = listOf(
                navArgument("nombreLibro") { type = NavType.StringType },
                navArgument("fecha") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            val fecha = backStackEntry.arguments?.getString("fecha") ?: ""

            RenovarReserva(navController, nombreLibro, fecha)
        }


        composable(
            route = Routes.RenovacionExitosa.route,
            arguments = listOf(
                navArgument("nombreLibro") { type = NavType.StringType },
                navArgument("fechaNueva") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombreLibro = backStackEntry.arguments?.getString("nombreLibro") ?: ""
            val fechaNueva = backStackEntry.arguments?.getString("fechaNueva") ?: ""

            RenovacionExitosa(navController, nombreLibro, fechaNueva)
        }
    }
}