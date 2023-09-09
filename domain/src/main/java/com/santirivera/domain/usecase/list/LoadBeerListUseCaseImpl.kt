package com.santirivera.domain.usecase.list

import android.util.Log
import com.santirivera.domain.model.BeerItem
import com.santirivera.domain.repo.BeerRepository

class LoadBeerListUseCaseImpl(private val beerRepository: BeerRepository) :
    LoadBeerListUseCase(beerRepository) {

    override suspend fun run(params: Void?): List<BeerItem> {
        return beerRepository.getBeerList()
    }
}