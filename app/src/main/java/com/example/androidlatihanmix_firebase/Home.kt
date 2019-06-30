package com.example.androidlatihanmix_firebase

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.example.androidlatihanmix_firebase.fragment.Cardlist
import com.example.androidlatihanmix_firebase.fragment.Profile
import com.example.androidlatihanmix_firebase.fragment.Update

class Home : AppCompatActivity() {
    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        toolbar = supportActionBar!!
        val bottom_menu: BottomNavigationView = findViewById(R.id.navigation)
        bottom_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.card -> {

                val cardlist = Cardlist.newInstance()
                openFragment(cardlist)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {

                val profile = Profile.newInstance()
                openFragment(profile)
                return@OnNavigationItemSelectedListener true
            }
            R.id.update -> {

                val update = Update.newInstance()
                openFragment(update)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}