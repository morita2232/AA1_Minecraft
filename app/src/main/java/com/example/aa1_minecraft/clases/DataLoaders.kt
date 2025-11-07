package com.example.aa1_minecraft.clases

import com.example.aa1_minecraft.R

class DataLoaders (){
    fun loadEncantamientosInfo() : List<Encantamientos>{
        return listOf(
            Encantamientos( EncantamientosDisponibles.IRROMPIBILIDAD, "Reduce la probabilidad de que un objeto sufra daños.", 3, 1.7f, 5, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.RESPIRACION, "Extiende el tiempo de respiración bajo el agua.", 3, 1.7f, 2, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.FILO, "Aumenta el daño de armas cuerpo a cuerpo.", 5, 1.7f, 10, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.EFICIENCIA, "Aumenta la velocidad al minar.\n" +
                    "En hachas, incrementa la probabilidad de que puedan aturdir un escudo, con una probabilidad inicial de 25% que incrementa un 5% por cada nivel.", 5, 2.0f, 10, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.PROTECCION_CONTRA_EL_FUEGO, "Reduce el daño por fuego y el tiempo de quemadura.", 4, 1.7f, 5, false, R.drawable.enchanted),
            Encantamientos( EncantamientosDisponibles.AFINIDAD_ACTUATICA, "Aumenta la velocidad de las herramientas al minar bajo agua.", 1, 1.7f, 2, false, R.drawable.enchanted)
        )
    }
}