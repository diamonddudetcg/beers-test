package com.santirivera.frogtekbeertest.di

import com.santirivera.data.api.BeersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val baseUrl = "https://random-data-api.com/api/v2/"

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit): BeersApi = retrofit.create(BeersApi::class.java)


}