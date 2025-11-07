package com.example.aa1_minecraft.models

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TopBar(){
    var expanded by remember {mutableStateOf(false)}
    val items = listOf("1.7", "1.8")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = { expanded =!expanded }, modifier = Modifier
            .border(BorderStroke(4.dp, Color.Red))
            .size(width = 130.dp, height = 50.dp),
            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            shape = RoundedCornerShape(0.dp)) {
            Row {
                Text(text = "Versión: ")
                Text(text = Version.version)
            }
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            items.forEach { item ->
                DropdownMenuItem(text = { Text(text = item) }, onClick = { Version.version = item; expanded = false })
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        var text by remember { mutableStateOf("Buscar") }
        TextField(value = text, onValueChange = {text = it}, modifier = Modifier.fillMaxWidth())
    }
}
