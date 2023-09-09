package com.santirivera.frogtekbeertest.fragment.list.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.santirivera.domain.model.BeerItem
import com.santirivera.frogtekbeertest.R
import com.santirivera.frogtekbeertest.databinding.ItemListContentBinding

class FrogtekBeerViewHolder(private val binding: ItemListContentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    interface OnBeerClickedCallback {
        fun onBeerClicked(item: BeerItem)
    }

    fun setElement(
        item: BeerItem, callback: OnBeerClickedCallback
    ) {
        val context = itemView.context
        val brand = context.getString(R.string.brand, item.brand)
        val alcohol = context.getString(R.string.alcohol_content, item.alcohol)
        val name = context.getString(R.string.name, item.name)
        val style = context.getString(R.string.style, item.style)
        binding.textViewBeerBrand.text = brand
        binding.textViewBeerAlcohol.text = alcohol
        binding.textViewBeerName.text = name
        binding.textViewBeerStyle.text = style
        itemView.setOnClickListener { callback.onBeerClicked(item) }
    }
}