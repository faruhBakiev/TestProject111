package com.example.presentation.models

import com.example.domain.models.FilmResponse

data class FilmsResponseUI (
    val image: String = "",
    val originalTitle: String = "",
    val director: String = "",
    val description: String = "",
    val vehicles: List<String>?,
    val title: String = "",
    val rtScore: String = "",
    val people: List<String>?,
    val url: String = "",
    val releaseDate: String = "",
    val species: List<String>?,
    val originalTitleRomanised: String = "",
    val producer: String = "",
    val runningTime: String = "",
    val locations: List<String>?,
    val id: String = "",
    val movieBanner: String = ""
)

fun FilmResponse.toUi(): FilmsResponseUI {
    return FilmsResponseUI(
        image,
        originalTitle,
        director,
        description,
        vehicles,
        title,
        rtScore,
        people,
        url,
        releaseDate,
        species,
        originalTitleRomanised,
        producer,
        runningTime,
        locations
    )
}


fun FilmsResponseUI.toUi(): FilmsResponseUI {
    return FilmsResponseUI(
        image,
        originalTitle,
        director,
        description,
        vehicles,
        title,
        rtScore,
        people,
        url,
        releaseDate,
        species,
        originalTitleRomanised,
        producer,
        runningTime,
        locations
    )
}