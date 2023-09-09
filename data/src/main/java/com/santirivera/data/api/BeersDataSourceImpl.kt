package com.santirivera.data.api

import com.santirivera.data.api.model.ResponseBeer

class BeersDataSourceImpl(

    private val beersApi: BeersApi,
) : BeersDataSource {

    override suspend fun getBeerList(size: Int): ArrayList<ResponseBeer> {
        return beersApi.getBeers(size)
    }
}