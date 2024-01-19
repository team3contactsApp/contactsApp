package com.android.team3_contactsapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
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

        group = intent.getParcelableExtra("Minyong", Group::class.java)


        with(binding) {
            ivBackButton.setOnClickListener {
                finish()
            }

            ivGroupDetailImg.setImageResource(group!!.groupImg)
            tvGroupDetailName.text = group!!.groupName
            tvGroupDesc.text = group!!.groupDesc
        }

        val joinedMemberAdapter = JoinedMemberAdapter(group!!.joinedMemberId)
        binding.rvMemberList.adapter=joinedMemberAdapter
        binding.rvMemberList.layoutManager = LinearLayoutManager(this,GridLayoutManager.HORIZONTAL,false)

        joinedMemberAdapter.itemClick = object : JoinedMemberAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val memberId = group!!.joinedMemberId[position]
                val data = Data.member.find {
                    memberId == it.memberId
                }
                //Log.d("test", "onViewCreated data =  ${data}")
                val intent = Intent(this@GroupDetailActivity,ContactDetailActivity::class.java)
                intent.putExtra("data",data)
                startActivity(intent)
            }
        }

    }
}