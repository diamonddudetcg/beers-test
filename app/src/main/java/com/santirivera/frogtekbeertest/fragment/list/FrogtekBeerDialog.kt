package com.santirivera.frogtekbeertest.fragment.list

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.TextView
import com.santirivera.domain.model.BeerItem
import com.santirivera.frogtekbeertest.R
import kotlin.text.StringBuilder

class FrogtekBeerDialog(context: Context, private val beerItem: BeerItem) : Dialog(context) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(true)
        setContentView(R.layout.dialog_beer_item)

        val title = beerItem.name
        val description = beerItem.getDescription()

        val titleView = findViewById<TextView>(R.id.dialogTextViewBeerName)
        val detailsView = findViewById<TextView>(R.id.dialogTextViewBeerDetails)

        titleView.text = title
        detailsView.text = description
    }

    private fun BeerItem.getDescription(): String {
        val sb = StringBuilder()

        sb.append("Brand:\n  ${brand}\n")
        sb.append("Style:\n  ${style}\n")
        sb.append("Alcohol content:\n  ${alcohol}\n")
        sb.append("\n")
        sb.append("Malts:\n  ${malts}\n")
        sb.append("Hop:\n  ${hop}\n")
        sb.append("Yeast:\n  ${yeast}\n")
        sb.append("IBU:\n  ${ibu}\n")
        sb.append("Blg:\n  ${blg}")
        return sb.toString()
    }

}