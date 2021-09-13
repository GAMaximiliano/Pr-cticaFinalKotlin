package com.redox.fragments

import android.content.Context
import android.content.SharedPreferences
import android.media.Image
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.moshi.Moshi

class ViewDetail : Fragment(R.layout.fragment_view_detail) {

    lateinit var star: ImageView
    lateinit var saveMusic: ImageView
    lateinit var txtVDetails: TextView
    lateinit var imageDetail: ImageView
    lateinit var lstPictireClas: listPicture
    lateinit var pic: Picture
    lateinit var sharedPreferences: SharedPreferences

    var index2 = 0
    var PREFERENCE_ID = "MY_PREFERENCE_ID"
    var MY_IMAGES = "MY_IMAGES"
    var moshi = Moshi.Builder().build()

    override fun onResume() {
        super.onResume()
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_ID, Context.MODE_PRIVATE)
        lstPictireClas = requireArguments().getParcelable("imagenes")!!
        index2 = requireArguments().getInt("index")!!
        pic = lstPictireClas.arrayPictures.get(index2)

        initViews()
    }

    private fun initViews() {
        star = requireView().findViewById(R.id.star)
        saveMusic = requireView().findViewById(R.id.saveMusic)
        txtVDetails = requireView().findViewById(R.id.txtViewDetail)
        imageDetail = requireView().findViewById(R.id.imgDetail)

        imageDetail.setImageResource(pic.source)
        txtVDetails.setText(pic.descripcion)

        if ( pic.like )
            star.setImageResource(R.drawable.ic_round_star_24_yellow)
        else
            star.setImageResource(R.drawable.ic_round_star_border_24)

        if ( pic.save )
            saveMusic.setImageResource(R.drawable.ic_baseline_library_music_24_ok)
        else
            saveMusic.setImageResource(R.drawable.ic_outline_library_music_24)

        star.setOnClickListener {
            pic.like = !pic.like
            if ( pic.like )
                star.setImageResource(R.drawable.ic_round_star_24_yellow)
            else
                star.setImageResource(R.drawable.ic_round_star_border_24)
            lstPictireClas.arrayPictures[index2].like = pic.like
            sharedPreferences.edit().putString(MY_IMAGES, moshi.adapter(listPicture::class.java).toJson(lstPictireClas)).commit()
        }

        saveMusic.setOnClickListener {
            pic.save = !pic.save
            if ( pic.save ) {
                saveMusic.setImageResource(R.drawable.ic_baseline_library_music_24_ok)
                MediaPlayer.create(context, R.raw.page).start()
            } else
                saveMusic.setImageResource(R.drawable.ic_outline_library_music_24)
            lstPictireClas.arrayPictures[index2].save = pic.save
            sharedPreferences.edit().putString(MY_IMAGES, moshi.adapter(listPicture::class.java).toJson(lstPictireClas)).commit()
        }

        imageDetail.setOnClickListener {
            (activity as MainActivity).changeFragments(Complete().apply {
                arguments = Bundle().apply {
                    putParcelable("img", pic)
                }
            })
        }

    }

}