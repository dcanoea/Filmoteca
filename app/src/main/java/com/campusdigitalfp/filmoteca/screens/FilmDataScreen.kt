package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.AbsoluteAlignment
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FilmDataScreen(navController: NavHostController, nombrePelicula : String) {
    var resultadoEditado by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    FilmotecaTheme {
        Scaffold(topBar = {
            BarraSuperiorComun(
                navController = navController,
                atras = true
            )
        }) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 120.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.cartel),
                        contentDescription = stringResource(R.string.imagen_de_perfil),
                        modifier = Modifier.size(150.dp)
                    )

                    Spacer(modifier = Modifier.padding(20.dp))

                    Column {
                        Text(text = "Nombre: $nombrePelicula")
                        Text(stringResource(R.string.director))
                        Text(stringResource(R.string.nombredirector))
                        Text(stringResource(R.string.a_o))
                        Text(stringResource(R.string.numa_o))
                        Text(stringResource(R.string.genero))
                        Text(stringResource(R.string.formato))
                    }
                }





                // Mostrar resultado si la película fue editada o no
                resultadoEditado?.let {
                    Text(text = it, style = MaterialTheme.typography.bodyLarge)
                }

// fila ------------------------------------------------------------------------------
                Row {
                    Button(modifier = Modifier.fillMaxWidth(), onClick = {
                        abrirPaginaWeb("https://www.imdb.com/es-es/", context)
                    }) {
                        Text(stringResource(R.string.ver_en_imdb))
                    }
                }
// fila ------------------------------------------------------------------------------
                Row (modifier = Modifier.fillMaxWidth()){
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), onClick = {
                        navController.popBackStack(route = "FilmListScreen", inclusive = false)
                    }) {
                        Text(stringResource(R.string.volver))
                    }
                    Spacer(modifier= Modifier.padding(all = 4.dp))
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), onClick = { navController.navigate("FilmEditScreen") }) {
                        Text(stringResource(R.string.editar))
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


@Preview(showBackground = true)
@Composable
fun FilmDataScreenPreview() {
    FilmotecaTheme {
        FilmDataScreen(
            navController = NavHostController(LocalContext.current),
            nombrePelicula = "Pelicula"
        )
    }
}
