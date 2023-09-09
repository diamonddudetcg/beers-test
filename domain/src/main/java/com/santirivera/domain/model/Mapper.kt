package com.santirivera.domain.model

import com.santirivera.data.api.model.ResponseBeer

fun ResponseBeer.toBeerDetail(): BeerItem {
    return BeerItem(id, uid, brand, name, style, hop, yeast, malts, ibu, alcohol, blg)
}

fun ArrayList<ResponseBeer>.toBeerDetailList(): ArrayList<BeerItem> {
    val list = ArrayList<BeerItem>()
    for (beer in this) {
        list.add(beer.toBeerDetail())
    }
    return list
}