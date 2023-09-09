package com.santirivera.domain.usecase.list

import com.santirivera.domain.model.BeerItem
import com.santirivera.domain.repo.BeerRepository
import com.santirivera.domain.usecase.BaseUseCase

abstract class LoadBeerListUseCase(private val beerRepository: BeerRepository) : BaseUseCase<Void, List<BeerItem>>()