package com.santirivera.domain.repo

import com.santirivera.data.api.BeersDataSource
import com.santirivera.domain.model.BeerItem
import com.santirivera.domain.model.toBeerDetailList


class BeerRepositoryImpl(
    private val dataSource: BeersDataSource
) : BeerRepository {

    override suspend fun getBeerList(): ArrayList<BeerItem> {
        return dataSource.getBeerList(20).toBeerDetailList()
    }
}