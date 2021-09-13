package com.redox.fragments

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.squareup.moshi.Moshi
import java.lang.Exception

class ContainerViewPrincipal : Fragment(R.layout.fragment_container_view_principal) {

    lateinit var imageView: ImageView
    lateinit var btnSiguiente: Button
    lateinit var btnAnterior: Button
    lateinit var lst: listPicture
    lateinit var arrayList: Array<Picture>
    lateinit var picture: Picture
    lateinit var sharedPreferences: SharedPreferences
    lateinit var imgSound:ImageView

    var index = 0
    var PREFERENCE_ID = "MY_PREFERENCE_ID"
    var MY_IMAGES = "MY_IMAGES"
    var moshi = Moshi.Builder().build()

    override fun onResume() {
        super.onResume()

        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_ID, Context.MODE_PRIVATE)

        lst = getShared()
        arrayList = lst.arrayPictures
        picture = arrayList.get(index)

        initViews()
    }

    @JvmName("getListPictures1")
    private fun getShared(): listPicture {
        return sharedPreferences.getString(MY_IMAGES, null)?.let {
            return@let try {
                moshi.adapter(listPicture::class.java).fromJson(it)
            } catch (e: Exception) {
                listPicture()
            }
        } ?: listPicture()
    }

    private fun initViews() {
        imageView = requireView().findViewById(R.id.imagenContenedor)
        btnSiguiente = requireView().findViewById(R.id.btnSiguiente)
        btnAnterior = requireView().findViewById(R.id.btnAnterior)
        imgSound = requireView().findViewById(R.id.sound)

        if ( picture.save )
            imgSound.setImageResource(R.drawable.ic_baseline_library_music_24_ok)
        else
            imgSound.setImageResource(R.drawable.ic_outline_library_music_24)

        imageView.setImageResource(picture.source)

        imgSound.setOnClickListener { 
            if ( picture.save )
                MediaPlayer.create(context, R.raw.page)
        }

        btnSiguiente.setOnClickListener {
            if ( index == arrayList.size-1 )
                index = 0
            else
                index++
            picture = arrayList.get(index)
            imageView.setImageResource(picture.source)
            if ( picture.save )
                imgSound.setImageResource(R.drawable.ic_baseline_library_music_24_ok)
            else
                imgSound.setImageResource(R.drawable.ic_outline_library_music_24)
        }

        btnAnterior.setOnClickListener {
            if ( index == 0 )
                index = arrayList.size-1
            else
                index--
            picture = arrayList.get(index)
            imageView.setImageResource(picture.source)
            if ( picture.save )
                imgSound.setImageResource(R.drawable.ic_baseline_library_music_24_ok)
            else
                imgSound.setImageResource(R.drawable.ic_outline_library_music_24)
        }

        imageView.setOnClickListener {
            (activity as MainActivity).changeFragments(ViewDetail().apply {
                arguments = Bundle().apply {
                    putParcelable("imagenes", lst)
                    putInt("index", index)
                }
            })
        }
    }

}