package com.campusdigitalfp.filmoteca.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FilmListScreen") {
        // Ruta de AboutScreen
        composable("AboutScreen") { AboutScreen(navController) }

        // Ruta de FilmDataScreen con parámetro nombrePelicula
        composable(
            "FilmDataScreen/{nombrePelicula}",
            arguments = listOf(navArgument("nombrePelicula") { type = NavType.StringType })
        ) { backStackEntry ->
            // Obtener el parámetro nombrePelicula
            val nombrePelicula = backStackEntry.arguments?.getString("nombrePelicula")
            // Llamar a FilmDataScreen con el parámetro
            if (nombrePelicula != null) {
                FilmDataScreen(navController, nombrePelicula)
            }
        }

        // Ruta para FilmEditScreen
        composable("FilmEditScreen") { FilmEditScreen(navController) }

        // Ruta para FilmListScreen
        composable("FilmListScreen") { FilmListScreen(navController) }
    }
}
