package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FilmDataScreen(navController: NavHostController, nombrePelicula : String) {
    var resultadoEditado by remember { mutableStateOf<String?>(null) }

    FilmotecaTheme {
        Scaffold(topBar = {
            BarraSuperiorComun(
                navController = navController,
                atras = true
            )
        }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Text(text = "Película: $nombrePelicula")
                }

                // Mostrar resultado si la película fue editada o no
                resultadoEditado?.let {
                    Text(text = it, style = MaterialTheme.typography.bodyLarge)
                }

                Row {
                    Button(onClick = { navController.navigate("FilmDataScreen/Película relacionada") }) {
                        Text(stringResource(R.string.ver_pel_cula_relacionada))
                    }
                }

                Row {
                    Button(onClick = { navController.navigate("FilmEditScreen") }) {
                        Text(stringResource(R.string.editar_pel_cula))
                    }
                }

                Row {
                    Button(onClick = {
                        navController.popBackStack(route = "FilmListScreen", inclusive = false)
                    }) {
                        Text(text = stringResource(R.string.volver_a_la_principal))
                    }
                }
            }
        }
        // Lógica para manejar el resultado de FilmEditScreen
        LaunchedEffect(Unit) {
            navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>("resultado")
                ?.observeForever {
                    resultadoEditado = it
                }
        }
    }
}