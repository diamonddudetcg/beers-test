package com.santirivera.data.api

import com.santirivera.data.api.model.ResponseBeer
import retrofit2.http.GET
import retrofit2.http.Query

interface BeersApi {

    @GET("beers")
    suspend fun getBeers(
        @Query("size") size: Int,
    ): ArrayList<ResponseBeer>

}