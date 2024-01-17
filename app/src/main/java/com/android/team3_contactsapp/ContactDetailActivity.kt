package com.android.team3_contactsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.team3_contactsapp.databinding.ActivityContactDetailBinding
import kotlin.RuntimeException

class ContactDetailActivity : AppCompatActivity(), FragmentDataListener {
    private lateinit var binding: ActivityContactDetailBinding
    private var member: Member? = null
    private val groupList: MutableList<Group> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton: ImageView = findViewById(R.id.iv_back)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onDataReceived(data: Member) {
        member = data
        updateUI()
    }

    private fun updateUI() {
        binding.tvCtDetailName.text = member?.Name
        binding.ivCtDetailMyPicture.setImageResource(member?.MemberImg ?: 0)
        binding.tvCtDetailMobileNum.text = member?.myPhoneNumber

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

        updateGroupInfo(0, member?.joinedGroupId.orEmpty())
        updateGroupInfo(1, member?.joinedGroupId.orEmpty())
        updateGroupInfo(2, member?.joinedGroupId.orEmpty())
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

    private fun updateGroupInfo(index: Int, groupIds: List<String>) {
        if (index < groupIds.size) {
            val groupId = groupIds[index]
            val group = findGroupById(groupId)

            if (group != null) {
                val (groupNameId, groupDescId, groupPicId) = when (index) {
                    0 -> Triple(R.id.tv_ctDetail_groupName, R.id.tv_ctDetail_groupDesc, R.id.iv_ctDetail_groupPic)
                    1 -> Triple(R.id.tv_ctDetail_groupName1, R.id.tv_ctDetail_groupDesc1, R.id.iv_ctDetail_groupPic1)
                    2 -> Triple(R.id.tv_ctDetail_groupName2, R.id.tv_ctDetail_groupDesc2, R.id.iv_ctDetail_groupPic2)
                    else -> throw RuntimeException()
                }

                val tvGroupName = findViewById<TextView>(groupNameId)
                val tvGroupDesc = findViewById<TextView>(groupDescId)
                val ivGroupPic = findViewById<ImageView>(groupPicId)

                tvGroupName.text = group.groupName
                tvGroupDesc.text = group.groupDesc
                ivGroupPic.setImageResource(group.groupImg)
            }
        }
    }

    private fun findGroupById(groupId: String): Group? {
        return groupList.find { it.groupId == groupId }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}