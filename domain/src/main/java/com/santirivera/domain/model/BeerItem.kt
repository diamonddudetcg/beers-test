package com.santirivera.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeerItem(
    val id: Int = 0,
    val uid: String = "",
    val name: String = "",
    val brand: String = "",
    val style: String = "",
    val hop: String = "",
    val yeast: String = "",
    val malts: String = "",
    val ibu: String = "",
    val alcohol: String = "",
    val blg: String = ""
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (other is BeerItem) {
            return other.id == id
        }
        return false
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + uid.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + brand.hashCode()
        result = 31 * result + style.hashCode()
        result = 31 * result + hop.hashCode()
        result = 31 * result + yeast.hashCode()
        result = 31 * result + malts.hashCode()
        result = 31 * result + ibu.hashCode()
        result = 31 * result + alcohol.hashCode()
        result = 31 * result + blg.hashCode()
        return result
    }
}