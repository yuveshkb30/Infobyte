package com.yuvesh.infobyte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yuvesh.infobyte.databinding.ActivityForgotPasswordBinding
import com.yuvesh.infobyte.databinding.ActivitySignUpBinding

class ForgotPassword : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding


    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

         auth=FirebaseAuth.getInstance()

        binding.btnreset.setOnClickListener {

              val password=binding.enterEmail.text.toString()
            auth.sendPasswordResetEmail(password)
                .addOnSuccessListener {
                    Toast.makeText(this@ForgotPassword,"Pls check your mail", Toast.LENGTH_LONG ).show()
                    val intent = Intent(this@ForgotPassword, SignIn::class.java)
                    //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                }
                .addOnFailureListener {

                    Toast.makeText(this@ForgotPassword, it.toString(), Toast.LENGTH_SHORT).show()
                }
        }

    }
}