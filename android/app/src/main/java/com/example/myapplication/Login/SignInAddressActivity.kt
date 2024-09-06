package com.example.myapplication.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySignInAddressBinding
import com.example.myapplication.databinding.ActivitySignInBinding

class SignInAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivitySignInAddressBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_sign_in_address)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSearchAddress.setOnClickListener{
            startActivity(Intent(this@SignInAddressActivity, KakaoAddressWebView::class.java))
        }

    }


}