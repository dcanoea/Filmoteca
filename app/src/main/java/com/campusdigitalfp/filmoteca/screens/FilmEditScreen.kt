package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FilmEditScreen(navController: NavHostController) {

    FilmotecaTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = { Text("Filmoteca") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.previousBackStackEntry?.savedStateHandle?.set(
                                "resultado",
                                "Edición Cancelada"
                            )
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Atrás"
                            )
                        }
                    }
                )
            }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 120.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    //Imagen para el carteld e la película
                    Image(
                        painter = painterResource(id = R.drawable.cartel),
                        contentDescription = stringResource(R.string.cartel),
                        modifier = Modifier.size(100.dp)
                    )
                    // Boton capturar fotografia
                    Button(modifier = Modifier.weight(1f).padding(end = 8.dp), onClick = {}) {
                        Text("Capturar fotografía")
                    }
                    // Boton Seleccionar imagen
                    Button(modifier = Modifier.weight(1f), onClick = {}) {
                        Text("Seleccionar imagen")
                    }
                }

                //TextField titulo
                var titulo by remember { mutableStateOf("") }
                TextField(
                    value = titulo,
                    onValueChange = { newText -> titulo = newText },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    singleLine = true
                )

                //TextField director
                var director by remember { mutableStateOf("") }
                TextField(
                    value = director,
                    onValueChange = { newText -> director = newText },
                    label = { Text("Director") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    singleLine = true
                )

                //TextField año de estreno
                var anyo by remember { mutableIntStateOf(1997) }
                TextField(
                    value = anyo.toString(),
                    onValueChange = { newText ->
                        newText.toIntOrNull()?.let { validYear ->
                            anyo = validYear
                        }
                    },
                    label = { Text("Año") },
                    isError = anyo < 1888 || anyo > 2100,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    )
                )

                //TextField IMDB
                var url by remember { mutableStateOf("") }
                TextField(
                    value = url,
                    onValueChange = { newText -> url = newText },
                    label = { Text("Enlace a IMDB") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    singleLine = true
                )

                val context = LocalContext.current


                // DropdownMenu Género
                var expanded by remember { mutableStateOf(false) }
                val generoList = context.resources.getStringArray(R.array.genero_list).toList()
                var selectedOption by remember { mutableStateOf(generoList[0]) }

                Column {
                    Text(selectedOption, modifier = Modifier
                        .padding(16.dp)
                        .clickable { expanded = true }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
       /*
                        generoList.forEach { option ->
                            DropdownMenuItem(
                                onClick = {
                                selectedOption = option
                                expanded = false
                            }) {
                                Text = (option)
                            }
                        }
        */
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))



                // DropdownMenu Formato
                var expanded2 by remember { mutableStateOf(false) }
                val formatoList = context.resources.getStringArray(R.array.formato_list).toList()
                var selectedOption2 by remember { mutableStateOf(formatoList[0]) }
                Column {
                    Text(selectedOption2, modifier = Modifier
                        .padding(16.dp)
                        .clickable { expanded2 = true }
                    )

                    DropdownMenu(
                        expanded = expanded2,
                        onDismissRequest = { expanded2 = false }
                    ) {
                        /*
                                         formatoList.forEach { option2 ->
                                             DropdownMenuItem(
                                                 onClick = {
                                                 selectedOption2 = option2
                                                 expanded2 = false
                                             }) {
                                                 Text = (option2)
                                             }
                                         }
                         */
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                //Textfield comentarios
                var comentarios by remember { mutableStateOf("") }
                TextField(
                    value = comentarios,
                    onValueChange = { newText -> comentarios = newText },
                    label = { Text("Comentarios") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp)) // Espacio adicional


                Row(modifier = Modifier.fillMaxWidth()) {
                    // Botón "Guardar" que devuelve RESULT_OK
                    Button(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        onClick = {
                            navController.previousBackStackEntry?.savedStateHandle?.set(
                                "resultado",
                                "Película editada con éxito"
                            )
                            navController.popBackStack() // Volver a la pantalla anterior
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(stringResource(R.string.guardar))
                    }

                    Spacer(modifier = Modifier.width(8.dp)) // Espacio entre botones

                    // Botón "Cancelar" que devuelve RESULT_CANCELED
                    Button(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        onClick = {
                            navController.previousBackStackEntry?.savedStateHandle?.set(
                                "resultado",
                                "Edición cancelada"
                            )
                            navController.popBackStack() // Volver a la pantalla anterior
                        }
                    ) {
                        Text(stringResource(R.string.cancelar))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FilmEditScreenPreview() {
    FilmotecaTheme {
        FilmEditScreen(
            navController = NavHostController(LocalContext.current)
        )
    }
}