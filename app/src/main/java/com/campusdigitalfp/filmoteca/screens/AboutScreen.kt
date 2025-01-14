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
import androidx.compose.ui.res.stringResource
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

@Composable
fun AboutScreen() {
    val context = LocalContext.current // Contexto necesario para el Toast

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    FilmotecaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.creada_por_david_cano_escario))

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = stringResource(R.string.imagen_de_perfil),
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.padding(all = 8.dp)) {
                Button(modifier = Modifier.weight(1f),onClick = {
                   showToast(context.getString(R.string.funci_n_no_implementada))
                }) {
                    Text(text = stringResource(R.string.ir_al_sitio_web))
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(modifier = Modifier.weight(1f),onClick = {
                    showToast(context.getString(R.string.funci_n_no_implementada))
                }) {
                    Text(text = stringResource(R.string.obtener_soporte))
                }
            } // fin fila

            Button(onClick = {
                showToast(context.getString(R.string.funci_n_no_implementada))
            }) {
                Text(text = stringResource(R.string.volver))
            }
        } // fin columna
    }
}