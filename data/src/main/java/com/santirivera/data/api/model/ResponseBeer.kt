package com.santirivera.data.api.model

data class ResponseBeer(
    val id: Int = 0,
    val uid: String = "",
    val brand: String = "",
    val name: String = "",
    val style: String = "",
    val hop: String = "",
    val yeast: String = "",
    val malts: String = "",
    val ibu: String = "",
    val alcohol: String = "",
    val blg: String = ""
)