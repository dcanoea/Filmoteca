package com.campusdigitalfp.filmoteca.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FilmListScreen") {
        composable("AboutScreen") { AboutScreen(navController) }
        composable("FilmDataScreen") { FilmDataScreen(navController) }
        composable("FilmEditScreen") { FilmEditScreen(navController)  }
        composable("FilmListScreen") { FilmListScreen(navController) }

    }
}