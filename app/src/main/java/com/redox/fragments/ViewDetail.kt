package com.redox.fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ViewDetail : Fragment(R.layout.fragment_view_detail) {

    lateinit var star: ImageView
    lateinit var saveMusic: ImageView
    lateinit var txtVDetails: TextView
    lateinit var imageDetail: ImageView
    lateinit var lstPictireClas: listPicture
    lateinit var pic: Picture

    var index2 = 0

    override fun onResume() {
        super.onResume()

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

        star.setOnClickListener {

        }

        saveMusic.setOnClickListener {

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