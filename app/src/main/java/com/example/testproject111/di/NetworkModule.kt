package com.example.testproject111.di

import com.example.data.remote.RetrofitClient
import com.example.data.remote.apiservices.FilmApiService
import com.example.data.remote.repositories.FilmsRepositoryImpl
import com.example.domain.repositories.FilmsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideCategoriesApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideFilmsApiService()

    @Singleton
    @Provides
    fun provideFilmsRepository(apiService: FilmApiService) : FilmsRepository {
        return FilmsRepositoryImpl(apiService)
    }
}