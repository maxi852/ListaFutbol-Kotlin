package com.example.listadofutbol

data class Equipo(
    val id: Int,
    val nombre: String,
    val apodo: String,
    val estadio: String,
    val pais: Paises,
    val escudo: String
)

enum class Paises{
    ARGENTINA,BRAZIL,CHILE,COLOMBIA,URUGUAY
}