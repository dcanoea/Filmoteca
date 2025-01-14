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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@Composable
fun FilmDataScreen(navController: NavHostController, nombrePelicula : String) {
    FilmotecaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Row {
                Text(text = "Película: $nombrePelicula")
            }
            Row {
                Button(onClick = { navController.navigate("FilmDataScreen/Película relacionada")}) {
                    Text(stringResource(R.string.ver_pel_cula_relacionada))
                }
            }

            Row{
                Button(onClick = { navController.navigate("FilmEditScreen")}) {
                    Text(stringResource(R.string.editar_pel_cula))
                }
            }

            Row{
                Button(onClick = {
                    navController.popBackStack(route = "FilmListScreen", inclusive = false)
                }) {
                    Text(text = stringResource(R.string.volver_a_la_principal))
                }
            }
        }
    }
}