package com.example.librerias

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator

import plibrerias.shared.generated.resources.Res
import plibrerias.shared.generated.resources.carrito
import plibrerias.shared.generated.resources.papamovil

private val autos = listOf(
    Auto(Res.drawable.papamovil, "DIOS", "SUPER PAPA", 5555, 100_000),
    Auto(Res.drawable.carrito, "juguete", "Carrito veloz", 1000, 100_000_000)
)

@Composable
@Preview
fun App() {
    // PreComposeApp: punto de entrada obligatorio de PreCompose
    PreComposeApp {
       AppTheme {
           val colors = getColorTheme()

        MaterialTheme {
            // Navigator de PreCompose: controla a qué pantalla vamos y el "regresar"
            val navigator = rememberNavigator()

            NavHost(
                navigator = navigator,
                initialRoute = "/lista",
            ) {
                // Pantalla 1: lista de autos
                scene(route = "/lista") {
                    PantallaLista(
                        autos = autos,
                        onAutoClick = { indice -> navigator.navigate("/detalle/$indice") },
                    )
                }

                // Pantalla 2: detalle; {indice} viaja en la ruta
                scene(route = "/detalle/{indice}") { backStackEntry ->
                    val indice = backStackEntry.path<Int>("indice") ?: 0
                    PantallaDetalle(
                        auto = autos[indice],
                        onRegresar = { navigator.goBack() },
                    )
                }
            }
        }
    }
    }
}
