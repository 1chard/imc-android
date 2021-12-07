package com.example.imcapp.util

import java.text.SimpleDateFormat
import java.util.*

fun dataAtualBrasil(): String{

    val hoje = Date()
    val formatoBrasil = SimpleDateFormat("dd/MM/yyyy", Locale("pt"))


    val hojeString = formatoBrasil.format(hoje)

    return hojeString
}