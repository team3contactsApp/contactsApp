package com.android.team3_contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.ActivityContactDetailBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemContactDetailJoinedgroupBinding
import kotlin.RuntimeException

class ContactDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetailBinding
    private var member: Member? = null
    private val groupList: MutableList<Group> = mutableListOf()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        member =intent.getParcelableExtra("data",Member::class.java)
        Log.d("test","로그가 잘 돌아왔는지 확인 ${member}")
        val backButton: ImageView = findViewById(R.id.iv_back)

        backButton.setOnClickListener {
            onBackPressed()
        }

        binding.tvCtDetailName.text = member?.Name
        binding.ivCtDetailMyPicture.setImageResource(member?.MemberImg ?: 0)
        binding.tvCtDetailMobileNum.text = member?.myPhoneNumber
        binding.tvCtDetailNatureNum.text = member?.actCnt.toString()
        binding.tvCtDetailNatureName.text = member?.title
        binding.tvCtDetailGroupNameGroup.text = "${member?.Name}이 가입한 모임들"

        val btnMessage : Button = findViewById(R.id.btn_message)
        val btnCall : Button = findViewById(R.id.btn_call)

        btnMessage.setOnClickListener {
            member?.myPhoneNumber?.let { phoneNumber ->
                sendMessage(phoneNumber)
            }
        }
        btnCall.setOnClickListener {
            member?.myPhoneNumber?.let { phoneNumber ->
                sendCall(phoneNumber)
            }
        }

        val ctJoinedGroupAdapter = ContactDetailJoinedGroupAdapter(member!!.joinedGroupId)
        binding.recyclerviewCdJoinedGroup.adapter =ctJoinedGroupAdapter
        binding.recyclerviewCdJoinedGroup.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }


    private fun sendMessage(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
        intent.putExtra("sms_body", "안녕하세요, 메시지를 보내려고 합니다.")
        startActivity(intent)
    }

    private fun sendCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}