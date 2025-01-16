package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.common.Film
import com.campusdigitalfp.filmoteca.common.FilmDataSource
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FilmListScreen(navController: NavHostController) {

    val isActionMode = remember { mutableStateOf(false) }
    val selectedFilms = remember { mutableStateListOf<Film>() }

    FilmotecaTheme {
        Scaffold(topBar = {
            BarraSuperiorComun(
                navController = navController,
                atras = false,
                isActionMode,
                selectedFilms
            )
        }) {
            Column(modifier = Modifier.padding(top = 120.dp)) {
                val films = FilmDataSource.films
                FilmList(films, navController, isActionMode, selectedFilms)
            }
        }
    }
}

@Composable
fun FilmList(
    films: List<Film>,
    navController: NavHostController,
    isActionMode: MutableState<Boolean>,
    selectedFilms: MutableList<Film>
) {
    LazyColumn {
        items(films) { film ->
            FilmItem(film, onClick = {
                if (isActionMode.value) {
                    // Seleccionar/deseleccionar habito
                    if (selectedFilms.contains(film)) {
                        selectedFilms.remove(film)
                        if (selectedFilms.isEmpty()) {
                            isActionMode.value = false // Desactiva action mode
                        }
                    } else {
                        selectedFilms.add(film)
                    }
                } else {
                    navController.navigate("FilmListScreen")
                }
            }, onLongClick = {
                isActionMode.value = true
                selectedFilms.add(film) // Agregar a la selección
            },
                isSelected = selectedFilms.contains(film)
            )
        }
        }
    }


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilmItem(film: Film, onClick: () -> Unit, onLongClick: () -> Unit, isSelected: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .combinedClickable(onClick = onClick, onLongClick = onLongClick)
    ) {
        Image(
            painter = painterResource(if (isSelected) R.drawable.comprobado
                                        else R.drawable.cartel),
            contentDescription = film.title,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = film.title.toString(),
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Director: ${film.director}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

