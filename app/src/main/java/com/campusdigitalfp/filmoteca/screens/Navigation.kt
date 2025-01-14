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
        composable("AboutScreen") { AboutScreen(navController) }
        composable("FilmEditScreen") { FilmEditScreen(navController) }
        composable("FilmListScreen") { FilmListScreen(navController) }


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

    }
}
