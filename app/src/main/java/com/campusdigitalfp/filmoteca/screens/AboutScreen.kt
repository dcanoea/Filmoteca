package com.campusdigitalfp.filmoteca.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.campusdigitalfp.filmoteca.R
import com.campusdigitalfp.filmoteca.common.BarraSuperiorComun
import com.campusdigitalfp.filmoteca.ui.theme.FilmotecaTheme

fun abrirPaginaWeb(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url) // Establece la URL que quieres abrir
    }
    context.startActivity(intent) // Inicia la actividad
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutScreen(navController: NavHostController) {
    val context = LocalContext.current // Contexto necesario para el Toast


    @SuppressLint("QueryPermissionsNeeded")
    fun mandarEmail(context: Context, email: String, asunto: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")  // URI de tipo mailto
            putExtra(Intent.EXTRA_SUBJECT, asunto)  // Asunto del correo
        }

        // Verifica si hay una aplicación de correo que pueda manejar este Intent
        val packageManager = context.packageManager
        if (intent.resolveActivity(packageManager) != null) {
            context.startActivity(intent)  // Inicia la actividad para enviar el correo
        }
    }
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
                Text(text = stringResource(R.string.creada_por_david_cano_escario))

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = stringResource(R.string.imagen_de_perfil),
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.padding(all = 8.dp)) {
                    Button(modifier = Modifier.weight(1f), onClick = {
                        abrirPaginaWeb("https://github.com/dcanoea/", context)
                    }) {
                        Text(text = stringResource(R.string.ir_al_sitio_web))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(modifier = Modifier.weight(1f), onClick = {
                        mandarEmail(
                            context = context,
                            email = "eagullof@campusdigitalfp.es",
                            asunto = context.getString(R.string.incidencia_con_filmoteca)
                        )
                    }) {
                        Text(text = stringResource(R.string.obtener_soporte))
                    }
                } // fin fila

                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = stringResource(R.string.volver))
                }
            } // fin columna
        }
    }
}