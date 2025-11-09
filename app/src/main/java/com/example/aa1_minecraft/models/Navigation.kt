package com.example.aa1_minecraft.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrapper(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "encantamientos"){
        composable(route = "encantamientos"){ EncantamientoEscena(modifier, navController)}
        composable(route = "mobs"){ MobsEscena(modifier, navController)}
    }
}