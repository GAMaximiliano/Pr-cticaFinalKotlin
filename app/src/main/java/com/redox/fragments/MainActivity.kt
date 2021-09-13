package com.redox.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(
                R.id.fragmentContainer,
                ContainerViewPrincipal()
            )
            .commit()

    }

    fun changeFragments(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction().apply {
                setCustomAnimations(
                    R.anim.in_down,
                    R.anim.out_top,
                    R.anim.out_down,
                    R.anim.in_top
                )
                replace(
                    R.id.fragmentContainer,
                    fragment
                )
                addToBackStack(fragment.tag)
                commit()
            }

    }

}