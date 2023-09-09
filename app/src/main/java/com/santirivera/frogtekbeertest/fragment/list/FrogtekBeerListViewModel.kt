package com.santirivera.frogtekbeertest.fragment.list

import androidx.lifecycle.ViewModel
import com.santirivera.domain.model.BeerItem
import dagger.hilt.android.lifecycle.HiltViewModel
import com.santirivera.domain.usecase.Callback
import com.santirivera.domain.usecase.list.LoadBeerListUseCase
import javax.inject.Inject

@HiltViewModel
class FrogtekBeerListViewModel @Inject constructor(
    private val loadBeerListUseCase: LoadBeerListUseCase
) :
    ViewModel(){

    fun loadBeers(callback: Callback<List<BeerItem>>) {
        loadBeerListUseCase.execute(null, callback)
    }
}