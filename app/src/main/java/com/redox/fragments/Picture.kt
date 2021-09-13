package com.redox.fragments

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Picture(
    var descripcion: String? = "Descripcion",
    var source: Int,
    var save: Boolean = false,
    var like: Boolean = false,

) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
class listPicture(
    val arrayPictures: Array<Picture> = arrayOf(
        Picture("Don Quijote", R.drawable.ic_don_quijote),
        Picture("Harry Potter", R.drawable.ic_harry_potter),
        Picture("Dracula", R.drawable.ic_dracula),
        Picture("El jugador", R.drawable.ic_jugador)
    )
) : Parcelable