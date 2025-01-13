package com.campusdigitalfp.filmoteca.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@Composable
fun AboutScreen() {
    val context = LocalContext.current // Contexto necesario para el Toast

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    // Aplicamos FilmotecaTheme aquí para envolver la UI
    FilmotecaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Creada por David Cano Escario")

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Imagen de perfil",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.padding(all = 8.dp)) {
                Button(onClick = {
                   showToast("Función no implementada")
                }) {
                    Text(text = "Ir al sitio web")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {
                    showToast("Función no implementada")
                }) {
                    Text(text = "Obtener soporte")
                }
            } // fin fila

            Button(onClick = {
                showToast("Función no implementada")
            }) {
                Text(text = "Volver")
            }
        } // fin columna
    }
}

