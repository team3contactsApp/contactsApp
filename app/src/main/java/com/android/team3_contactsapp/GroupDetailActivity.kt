package com.android.team3_contactsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.ActivityGroupDetailBinding

class GroupDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupDetailBinding
    private var group : Group? = null
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        group = intent.getParcelableExtra("data",Group::class.java)
//        group?.let {
//            binding.ivGroupDetailImg.setImageResource(it.groupImg)
//            binding.tvGroupDetailName.text = it.groupName
//            binding.tvGroupDesc.text = it.groupDesc
//            binding.rvMemberList.adapter
//        }
//



        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(
                "Minyong", Group::class.java
            )
        } else {
            intent?.getParcelableExtra(
                "Minyong"
            )
        }

        with(binding) {
            ivBackButton.setOnClickListener {
                finish()
            }

            ivGroupDetailImg.setImageResource(data!!.groupImg)
            tvGroupDetailName.text = data.groupName
            tvGroupDesc.text = data.groupDesc
        }

        val joinedMemberAdapter = JoinedMemberAdapter(data!!.joinedMemberId)
        binding.rvMemberList.adapter=joinedMemberAdapter
        binding.rvMemberList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }
}