package com.santirivera.frogtekbeertest.di

import com.santirivera.data.api.BeersDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.santirivera.domain.repo.BeerRepository
import com.santirivera.domain.repo.BeerRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesBeerRepository(
        dataSource: BeersDataSource
    ): BeerRepository = BeerRepositoryImpl(dataSource)

}