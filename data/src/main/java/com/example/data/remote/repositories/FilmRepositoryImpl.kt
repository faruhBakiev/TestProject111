package com.example.data.remote.repositories

import com.example.data.base.BaseRepository
import com.example.data.remote.apiservices.FilmApiService

import com.example.data.dtos.toDomain
import com.example.domain.repositories.FilmsRepository
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(private val service: FilmApiService) :
    FilmsRepository, BaseRepository(){

    override fun fetchFilms() = doRequest {
        service.fetchFilms().map {
            it.toDomain()
        }
    }
}