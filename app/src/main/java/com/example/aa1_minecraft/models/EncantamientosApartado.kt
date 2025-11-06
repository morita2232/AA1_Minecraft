package com.example.aa1_minecraft.models

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aa1_minecraft.R
import com.example.aa1_minecraft.clases.DataLoaders
import com.example.aa1_minecraft.clases.Encantamientos

@Composable
fun EncantamientoEscena(modifier: Modifier = Modifier) {
    val listaEncantamientos = DataLoaders().loadEncantamientosInfo()
    var encantamientoSelecciodo by remember { mutableStateOf<Encantamientos?>(null) }
    if (encantamientoSelecciodo != null) {
        EncantamientoConcreto(encantamiento = encantamientoSelecciodo!!)
    } else {
        Column(modifier = modifier
            .fillMaxSize()
            .padding(16.dp)){
            Text("Encantamientos disponibles:", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                for (i in 0..(listaEncantamientos.size - 1) step 2) {
                    item {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Button(onClick = { encantamientoSelecciodo = listaEncantamientos[i] }, modifier = Modifier
                                .border(BorderStroke(4.dp, Color.Red))
                                .size(width = 150.dp, height = 150.dp),
                                contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                                shape = RoundedCornerShape(0.dp)) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Image(painter = painterResource(id = listaEncantamientos[i].imageResourceID), contentDescription = null, modifier = Modifier.fillMaxSize())
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.BottomCenter)
                                        .padding(bottom = 5.dp)){
                                        Text(
                                            text = listaEncantamientos[i].encantamiento.nombre,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color.Black.copy(0.75f)),
                                            textAlign = TextAlign.Center,
                                            color = Color.Green
                                        )
                                    }
                                }
                            }
                            if(i+ 1 < listaEncantamientos.size){
                                Button(onClick = { encantamientoSelecciodo = listaEncantamientos[i + 1] }, modifier = Modifier
                                    .border(BorderStroke(4.dp, Color.Red))
                                    .size(width = 150.dp, height = 150.dp),
                                    contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                                    shape = RoundedCornerShape(0.dp)) {
                                    Box(modifier = Modifier.fillMaxSize()) {
                                        Image(painter = painterResource(id = listaEncantamientos[i + 1].imageResourceID), contentDescription = null, modifier = Modifier.fillMaxSize())
                                        Box(modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.BottomCenter)
                                            .padding(bottom = 5.dp)){
                                            Text(
                                                text = listaEncantamientos[i + 1].encantamiento.nombre,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .background(Color.Black.copy(0.75f)),
                                                textAlign = TextAlign.Center,
                                                color = Color.Green
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }

}

@Composable
fun EncantamientoConcreto(encantamiento: Encantamientos, modifier: Modifier = Modifier){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Encantamiento seleccionado:", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = encantamiento.imageResourceID),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = encantamiento.encantamiento.nombre, textAlign = TextAlign.Center, fontSize = 28.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = encantamiento.efecto, textAlign = TextAlign.Center)
                }
            }
            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .weight(1f), horizontalArrangement = Arrangement.Center){
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = "Nivel máximo",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Text(
                            text = encantamiento.nivelMaximo.toString(),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .weight(1f), horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = "Peso encantamiento",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = encantamiento.pesoEncantamiento.toString(),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .weight(1f), horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = "Se encuentra \nsolo en tesoros",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    if (encantamiento.halladoEnTesoro) {
                        Box(modifier = Modifier
                            .weight(1f)
                            .border(BorderStroke(2.dp, Color.Red))
                            .padding(2.dp)
                            .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                            .fillMaxSize(),
                            contentAlignment = Alignment.Center) {
                            Text(text = "Sí", fontSize = 20.sp, textAlign = TextAlign.Center)
                        }
                    } else {
                        Box(modifier = Modifier.weight(1f)
                            .border(BorderStroke(2.dp, Color.Red))
                            .padding(2.dp)
                            .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                            .fillMaxSize(),
                            contentAlignment = Alignment.Center){
                            Text(text = "No", fontSize = 20.sp, textAlign = TextAlign.Center)
                        }
                    }
                }
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .weight(1f), horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = "Disponible en los siguientes items",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(modifier = Modifier
                            .weight(1f)
                            .border(BorderStroke(2.dp, Color.Red))
                            .padding(2.dp)
                            .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                            .fillMaxSize(),
                            contentAlignment = Alignment.Center) {
                            LazyColumn {
                                item{
                                    for (item in encantamiento.encantamiento.itemsCompatibles) {
                                        Text(text = item.nombre, fontSize = 20.sp, textAlign = TextAlign.Center)
                                        Spacer(modifier = Modifier.height(2.dp))
                                    }
                                }

                            }
                        }
                    }
                Text(text = "Random texto para probar el diseño", fontSize = 30.sp, textAlign = TextAlign.Center)
            }
        }

}