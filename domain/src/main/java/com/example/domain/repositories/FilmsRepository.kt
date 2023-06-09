package com.example.domain.repositories

import com.example.domain.either.Either
import com.example.domain.models.FilmResponse
import kotlinx.coroutines.flow.Flow

interface FilmsRepository {

    fun fetchFilms(): Flow<Either<String, List<FilmResponse>>>
}


