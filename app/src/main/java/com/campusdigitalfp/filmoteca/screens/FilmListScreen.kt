package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.common.Film
import com.campusdigitalfp.filmoteca.common.FilmDataSource
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FilmListScreen(navController: NavHostController) {
    FilmotecaTheme {
        Scaffold(topBar = {
            BarraSuperiorComun(
                navController = navController,
                atras = false
            )
        }) {
            Column (modifier = Modifier.padding(top = 120.dp)) {
                val films = FilmDataSource.films
                FilmList(films)

            }



                /*Row {
                    Button(onClick = { navController.navigate("FilmDataScreen/Película A") }) {
                        Text(stringResource(R.string.ver_pel_cula_a))
                    }
                }

                Row {
                    Button(onClick = { navController.navigate("FilmDataScreen/PeliculaB") }) {
                        Text(stringResource(R.string.ver_pel_cula_b))
                    }
                }

                Row {
                    Button(onClick = { navController.navigate("AboutScreen") }) {
                        Text(stringResource(R.string.acerca_de))
                    }
                }*/
            }
        }
    }

@Composable
fun FilmList(films: List<Film>) {
    LazyColumn (modifier = Modifier.padding(horizontal = 20.dp)) {
        items(films) { film ->
            Text(
                text = film.title.toString(),
                maxLines = 1
            )
        }
    }
}

