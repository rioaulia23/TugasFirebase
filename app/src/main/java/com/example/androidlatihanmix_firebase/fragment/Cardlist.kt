package com.example.androidlatihanmix_firebase.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidlatihanmix_firebase.R

class Cardlist : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.cardlist, container, false)

    companion object {
        fun newInstance(): Cardlist = Cardlist()
    }
}