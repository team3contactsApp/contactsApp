package com.android.team3_contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.team3_contactsapp.databinding.ActivityGroupDetailBinding
import com.android.team3_contactsapp.databinding.ActivityMainBinding

class GroupDetailActivity : AppCompatActivity(),FragmentDataListener {
    private lateinit var binding: ActivityGroupDetailBinding
    private var member : Member? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDataReceived(data: Member) {
        member= data
    }
}