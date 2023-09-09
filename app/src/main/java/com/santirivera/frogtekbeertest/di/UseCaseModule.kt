package com.santirivera.frogtekbeertest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.santirivera.domain.repo.BeerRepository
import com.santirivera.domain.usecase.list.LoadBeerListUseCase
import com.santirivera.domain.usecase.list.LoadBeerListUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun providesBeerListUseCase(beerRepository: BeerRepository): LoadBeerListUseCase =
        LoadBeerListUseCaseImpl(beerRepository)

}