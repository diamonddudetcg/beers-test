package com.santirivera.frogtekbeertest.fragment.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santirivera.domain.model.BeerItem
import com.santirivera.frogtekbeertest.databinding.ItemListContentBinding
import com.santirivera.frogtekbeertest.fragment.list.adapter.viewholder.FrogtekBeerViewHolder
import java.util.*

class FrogtekBeerListAdapter(
    private val values: ArrayList<BeerItem>,
    private val callback: FrogtekBeerViewHolder.OnBeerClickedCallback) :
    RecyclerView.Adapter<FrogtekBeerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrogtekBeerViewHolder {
        val binding = ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FrogtekBeerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrogtekBeerViewHolder, position: Int) {
        val item = values[position]
        holder.setElement(item, callback)
    }

    override fun getItemCount() = values.size

    fun setNewValues(it: List<BeerItem>) {
        values.clear()
        values.addAll(it)
    }
}