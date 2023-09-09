package com.santirivera.domain.repo

import com.santirivera.domain.model.BeerItem

interface BeerRepository {

    suspend fun getBeerList(): ArrayList<BeerItem>

}