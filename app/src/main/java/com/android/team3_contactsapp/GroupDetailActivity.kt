package com.android.team3_contactsapp

import android.app.AlertDialog
import android.content.DialogInterface
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
    var isJoin: Boolean = false
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(
                "Minyong", Group::class.java
            )
        } else {
            intent?.getParcelableExtra(
                "Minyong"
            )
        }

        group = intent.getParcelableExtra("Minyong", Group::class.java)


        binding.apply {
            ivBackButton.setOnClickListener {
                finish()
            }

            ivGroupDetailImg.setImageResource(data!!.groupImg)
            tvGroupDetailName.text = data.groupName
            tvGroupDesc.text = data.groupDesc

            val findId = Data.myJoinedgroup.find {
                data.groupId == it.groupId
            }

            if (findId != null) {
                isJoin = true
                btnJoin.text = "가입 해제"
                btnJoin.setBackgroundColor(R.color.black.toInt())
            } else {
                isJoin = false
                btnJoin.text = "가입"
            }

            btnJoin.setOnClickListener {
                showJoinDialog()
                if (!isJoin) {
                    btnJoin.text = "가입 해제"
                    btnJoin.setBackgroundColor(R.color.black.toInt())
                    Data.myJoinedgroup.add(
                        MyJoinedGroup(
                            data.groupName,
                            data.groupImg,
                            data.groupId
                        )
                    )
                    isJoin = true
                } else {
                    btnJoin.text = "가입"
                    btnJoin.setBackgroundColor(com.google.android.material.R.color.mtrl_btn_bg_color_selector.toInt())
                    Data.myJoinedgroup.remove(findId)
                    isJoin = false
                }

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

    private fun showJoinDialog() {

        var builder = AlertDialog.Builder(this)
        builder.setTitle("기본 다이얼로그")
        builder.setMessage("기본 메세지")
        builder.setIcon(R.drawable.info)

        val listener = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which) {

                    //DialogInterface.BUTTON_POSITIVE ->
                    //DialogInterface.BUTTON_NEGATIVE ->
                }
            }
        }
        builder.setPositiveButton("네", listener)
        builder.setNegativeButton("아니오", listener)
        builder.show()
    }

    private fun checkJoin() {
//        with(binding) {
//            if (!isJoin) {
//                btnJoin.text = "가입 해제"
//                btnJoin.setBackgroundColor(R.color.black.toInt())
//                Data.myJoinedgroup.add(
//                    MyJoinedGroup(
//                        data.groupName,
//                        data.groupImg,
//                        data.groupId
//                    )
//                )
//                isJoin = true
//            } else {
//                btnJoin.text = "가입"
//                btnJoin.setBackgroundColor(com.google.android.material.R.color.mtrl_btn_bg_color_selector.toInt())
//                Data.myJoinedgroup.remove(findId)
//                isJoin = false
//            }
//        }
    }
}