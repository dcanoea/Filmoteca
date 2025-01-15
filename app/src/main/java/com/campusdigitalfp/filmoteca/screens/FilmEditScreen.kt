package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FilmEditScreen(navController: NavHostController) {
    val context = LocalContext.current

    FilmotecaTheme {
        Scaffold(topBar = {
            TopAppBar(// Definimos los colores personalizados para la TopAppBar
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer, // Color de fondo de la barra
                    titleContentColor = MaterialTheme.colorScheme.primary, // Color del título
                ),
                title = { Text("Filmoteca") },
                navigationIcon = {
                    IconButton(onClick = {
                        // Guardamos el resultado RESULT_CANCELED y volvemos atrás
                        navController.previousBackStackEntry?.savedStateHandle?.set("resultado", "Edición Cancelada")
                        navController.popBackStack() // Navegar hacia atrás
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row (modifier = Modifier.padding(top = 120.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Image(
                        painter = painterResource(id = R.drawable.cartel),
                        contentDescription = stringResource(R.string.cartel),
                        modifier = Modifier.size(100.dp)
                    )
                    Button(modifier = Modifier.weight(1f).padding(end = 8.dp), onClick = {}) {
                        Text("Capturar fotografía")

                    }
                    Button(modifier = Modifier.weight(1f), onClick = {}) {
                        Text("Seleccionar imagen")
                    }
                }


                Row (modifier = Modifier.fillMaxWidth()){
                    // Botón "Guardar" que devuelve RESULT_OK
                    Button(modifier = Modifier.fillMaxWidth().weight(1f), onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "resultado",
                            "Película editada con éxito"
                        )
                        navController.popBackStack() // Volver a la pantalla anterior
                    }) {
                        Text(stringResource(R.string.guardar))
                    }

                    // Botón "Cancelar" que devuelve RESULT_CANCELED
                    Button(modifier = Modifier.fillMaxWidth().weight(1f), onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            "resultado",
                            "Edición cancelada"
                        )
                        navController.popBackStack() // Volver a la pantalla anterior
                    }) {
                        Text(stringResource(R.string.cancelar))
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun FilmEditScreenPreview(){
    FilmotecaTheme {
        FilmEditScreen(
            navController = NavHostController(LocalContext.current)
        )
    }
}
