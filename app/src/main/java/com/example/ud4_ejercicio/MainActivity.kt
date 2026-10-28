package com.example.ud4_ejercicio

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ud4_ejercicio.ui.theme.Ud4_EjercicioTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud4_EjercicioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormularioPedido(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FormularioPedido(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Restaurante DAM",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Formulario(modifier)

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Formulario(modifier: Modifier = Modifier){
    var fecha by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    val listaProductos = listOf("Hamburguesa", "Pizza")
    var (eleccion, onOpcionElegida) = remember { mutableStateOf(listaProductos[0])}

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))



        Text(
            text = "Elige el producto",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Card(modifier = Modifier
.padding(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x5C3F51B5),
            )){
            Row(
                Modifier
                    .selectableGroup()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                listaProductos.forEach { opcion ->
                    val tipo = when (opcion) {
                        "Hamburguesa" -> R.drawable.hamburguesa
                        "Pizza" -> R.drawable.pizza
                        else -> R.drawable.pizza
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(tipo),
                            contentDescription = opcion,
                            modifier = Modifier.size(100.dp)
                                .selectable(
                                    selected = (opcion == eleccion),
                                    onClick = {
                                        eleccion = opcion
                                        onOpcionElegida(opcion)
                                    }
                                )
                        )
                        Row(
                            modifier = Modifier.selectable(
                                selected = (opcion == eleccion),
                                onClick = {
                                    eleccion = opcion
                                    onOpcionElegida(opcion)
                                }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (opcion == eleccion),
                                onClick = {
                                    eleccion = opcion
                                    onOpcionElegida(opcion)
                                    //ivaRadio = eleccion.toDouble()
                                })
                            Text(text = opcion)
                        }
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(50.dp))
            when (eleccion) {
                "Hamburguesa" -> {
//                    var anyo by remember { mutableStateOf("") }
//                    var listaProc = listOf("Intel", "AMD")
//                    var (elecc, onOpcionEleg) = remember { mutableStateOf(listaProc[0]) }
//                    var error by remember { mutableStateOf(false) }
//
//                    Column(
//                        modifier = modifier.fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        OutlinedTextField(
//                            value = anyo,
//                            onValueChange = {
//                                anyo = it
//                                if (anyo.length > 0)
//                                    if (anyo.toInt() in 2000..2024)
//                                        error = false
//                                    else
//                                        error = true
//                            },
//                            label = { Text("Año") },
//                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                            isError = error
//
//                        )
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Text(
//                                text = "Procesador",
//                                color = MaterialTheme.colorScheme.primary,
//                                style = MaterialTheme.typography.headlineMedium,
//                                modifier = Modifier.padding(bottom = 10.dp)
//                            )
//                            Column(Modifier.selectableGroup()) {
//                                listaProc.forEach { opcion ->
//                                    Row(
//                                        modifier = Modifier.selectable(
//                                            selected = (opcion == elecc),
//                                            onClick = {
//                                                elecc = opcion
//                                                onOpcionEleg(opcion)
//                                                //ivaRadio = eleccion.toDouble()
//                                            }
//                                        ),
//                                        verticalAlignment = Alignment.CenterVertically
//                                    ) {
//                                        RadioButton(
//                                            selected = (opcion == elecc),
//                                            onClick = {
//                                                elecc = opcion
//                                                onOpcionEleg(opcion)
//                                                //ivaRadio = eleccion.toDouble()
//                                            })
//                                        Text(text = opcion)
//                                    }
//                                }
//                            }
//                        }
//                    }
                }

                "Pizza" -> {
//                    var pulgadas by remember { mutableStateOf("") }
//                    var error by remember { mutableStateOf(false) }
//
//                    OutlinedTextField(
//                        value = pulgadas,
//                        onValueChange = {
//                            pulgadas = it
//                            if (pulgadas.length > 0)
//                                if (pulgadas.toInt() in 10..20)
//                                    error = false
//                                else
//                                    error = true
//                        },
//                        label = { Text("Pulgadas") },
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                        isError = error,
//                        modifier = modifier
//
//                    )
                }

                else -> {
                }
            }
Row(modifier = Modifier.fillMaxWidth()
    .padding(10.dp)) {
    OutlinedTextField(
        value = cantidad,
        onValueChange = { cantidad = it },
        label = { Text("Cantidad") },
        modifier = Modifier.weight(0.3f)
    )

    Spacer(modifier = Modifier.weight(0.1f))

    OutlinedTextField(
        value = LocalDate.now().toString(),
        onValueChange = { fecha = it },
        label = { Text("Fecha") },
        enabled = false,
        modifier = Modifier.weight(0.6f)
    )
}
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {  },
                modifier = Modifier.padding(end = 10.dp)) {
                Text(
                    text = "Añadir",
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                onClick = {  },
                modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = "Cancelar",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
    HorizontalDivider(modifier = Modifier.padding(5.dp))

}