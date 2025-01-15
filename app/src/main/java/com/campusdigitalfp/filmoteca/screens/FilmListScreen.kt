package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun FilmListScreen(navController: NavHostController) {
    FilmotecaTheme {
        Scaffold(topBar = {
            BarraSuperiorComun(
                navController = navController,
                atras = false
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
                }
            }
        }
    }
}