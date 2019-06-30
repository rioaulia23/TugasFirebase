package com.example.androidlatihanmix_firebase.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidlatihanmix_firebase.Login
import com.example.androidlatihanmix_firebase.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.profile.*

class Profile : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.profile, container, false)

    companion object {
        fun newInstance(): Profile = Profile()
    }

    lateinit var fAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fAuth = FirebaseAuth.getInstance()
        btn_logout.setOnClickListener {
            fAuth.signOut()
            val intent = Intent(context, Login::class.java)
            startActivity(intent)
            activity!!.finish()
        }
    }
}