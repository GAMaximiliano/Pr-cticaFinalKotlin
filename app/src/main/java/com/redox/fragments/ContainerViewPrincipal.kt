package com.redox.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class ContainerViewPrincipal : Fragment(R.layout.fragment_container_view_principal) {

    lateinit var imageView: ImageView
    lateinit var btnSiguiente: Button
    lateinit var btnAnterior: Button
    lateinit var lst: listPicture
    lateinit var arrayList: Array<Picture>
    lateinit var picture: Picture

    var index = 0

    override fun onResume() {
        super.onResume()

        lst = getShared()
        arrayList = lst.arrayPictures
        picture = arrayList.get(index)

        initViews()
    }

    @JvmName("getListPictures1")
    private fun getShared():listPicture {
        return listPicture()
    }

    private fun initViews() {
        imageView = requireView().findViewById(R.id.imagenContenedor)
        btnSiguiente = requireView().findViewById(R.id.btnSiguiente)
        btnAnterior = requireView().findViewById(R.id.btnAnterior)

        imageView.setImageResource(picture.source)

        btnSiguiente.setOnClickListener {
            if ( index == arrayList.size-1 )
                index = 0
            else
                index++
            picture = arrayList.get(index)
            imageView.setImageResource(picture.source)
        }

        btnAnterior.setOnClickListener {
            if ( index == 0 )
                index = arrayList.size-1
            else
                index--
            picture = arrayList.get(index)
            imageView.setImageResource(picture.source)
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