package com.example.librerias

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

/**
 * Componente reutilizable del boceto.
 * Recibe un [Auto] con: imagen, marca, modelo, año y precio.
 */
@Composable
fun TarjetaAuto(
    auto: Auto,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(auto.imagen),
                contentDescription = "${auto.marca} ${auto.modelo}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(12.dp)),
            )
            Column(
                modifier = Modifier.padding(start = 16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                DatoAuto("Modelo", auto.modelo)
                DatoAuto("Marca", auto.marca)
                DatoAuto("Año", auto.anio.toString())
                DatoAuto("Precio", formatearPrecio(auto.precio))
            }
        }
    }
}

@Composable
private fun DatoAuto(etiqueta: String, valor: String) {
    Row {
        Text(
            text = "$etiqueta:",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(64.dp),
        )
        Text(text = valor, style = MaterialTheme.typography.bodyMedium)
    }
}

/** Formatea 350000 -> "$350,000" (sin String.format, que no existe en commonMain). */
fun formatearPrecio(precio: Long): String =
    "$" + precio.toString().reversed().chunked(3).joinToString(",").reversed()
