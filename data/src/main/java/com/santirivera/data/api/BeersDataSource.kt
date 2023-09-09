package com.santirivera.data.api

import com.santirivera.data.api.model.ResponseBeer


interface BeersDataSource {

    @Throws(Exception::class)
    suspend fun getBeerList(size: Int): ArrayList<ResponseBeer>

}