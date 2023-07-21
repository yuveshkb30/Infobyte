package com.yuvesh.infobyte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.yuvesh.infobyte.databinding.ActivityMainBinding
import com.yuvesh.infobyte.databinding.ActivitySignInBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var logout:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonlogout.setOnClickListener{
            val i = Intent(this@MainActivity, SignUp::class.java)
            startActivity(i)
        }
    }


}



