package com.android.team3_contactsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.ActivityGroupDetailBinding
import com.android.team3_contactsapp.databinding.ActivityMainBinding

class GroupDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupDetailBinding
    private var group : Group? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        group = intent.getParcelableExtra("data",Group::class.java)
        group?.let {
            binding.ivGroupDetailImg.setImageResource(it.groupImg)
            binding.tvGroupDetailName.text = it.groupName
            binding.tvGroupDesc.text = it.groupDesc
            binding.rvMemberList.adapter
        }

        val joinedMemberAdapter = JoinedMemberAdapter(group!!.joinedMemberId)
        binding.rvMemberList.adapter=joinedMemberAdapter
        binding.rvMemberList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)


    }


}