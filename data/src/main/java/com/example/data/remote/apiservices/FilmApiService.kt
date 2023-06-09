package com.example.data.remote.apiservices

import com.example.data.dtos.FilmsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApiService {

    @GET("films")
    suspend fun fetchFilms(
        @Query("fields") fields: String = "",
        @Query("limit") limit: Int =0
    ):List<FilmsResponseDto>
}