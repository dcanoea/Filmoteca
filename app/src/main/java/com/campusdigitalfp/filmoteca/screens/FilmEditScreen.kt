package com.campusdigitalfp.filmoteca.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@Composable
fun FilmEditScreen(navController: NavHostController) {
    val context = LocalContext.current

    FilmotecaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Row {
                Text(stringResource(R.string.editando_pel_clula))
            }

            // Botón "Guardar" que devuelve RESULT_OK
            Row {
                Button(onClick = {
                    navController.previousBackStackEntry?.savedStateHandle?.set("resultado", "Película editada con éxito")
                    navController.popBackStack() // Volver a la pantalla anterior
                }) {
                    Text(stringResource(R.string.guardar))
                }
            }

            // Botón "Cancelar" que devuelve RESULT_CANCELED
            Row {
                Button(onClick = {
                    navController.previousBackStackEntry?.savedStateHandle?.set("resultado", "Edición cancelada")
                    navController.popBackStack() // Volver a la pantalla anterior
                }) {
                    Text(stringResource(R.string.cancelar))
                }
            }
        }
    }
}