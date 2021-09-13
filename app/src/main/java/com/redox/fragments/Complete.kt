package com.redox.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class Complete : Fragment(R.layout.fragment_complete) {

    lateinit var pictureComplete: Picture
    lateinit var imageComplete: ImageView

    override fun onResume() {
        super.onResume()

        pictureComplete = requireArguments().getParcelable("img")!!

        imageComplete = requireView().findViewById(R.id.imgComplete)

        imageComplete.setImageResource(pictureComplete.source)
    }
}