package com.android.team3_contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import com.android.team3_contactsapp.databinding.ActivityContactDetailBinding
import com.android.team3_contactsapp.databinding.ActivityMainBinding

class ContactDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton: ImageView = findViewById(R.id.iv_back)

        backButton.setOnClickListener {
            finish()
        }
    }
}