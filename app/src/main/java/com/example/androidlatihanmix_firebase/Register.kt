package com.example.androidlatihanmix_firebase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register.*

class Register : AppCompatActivity() {
    lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        fAuth = FirebaseAuth.getInstance()

        btn_regis.setOnClickListener {
            val email = et_email2.text.toString()
            val password = et_pass2.text.toString()
            if (email.isNotEmpty() || password.isNotEmpty() || !email.equals("")
                || !password.equals("")
            ) {
                fAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                this, "Registration Done!",
                                Toast.LENGTH_SHORT
                            ).show()
                            onBackPressed()
                        } else {
                            Toast.makeText(
                                this, "Failed To Registration",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(
                    this, "Email and Password must be input",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        back.setOnClickListener {
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}