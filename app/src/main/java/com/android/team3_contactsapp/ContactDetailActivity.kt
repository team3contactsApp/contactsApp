package com.android.team3_contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        updateGroupInfo(0, member?.joinedGroupId.orEmpty())
        updateGroupInfo(1, member?.joinedGroupId.orEmpty())
        updateGroupInfo(2, member?.joinedGroupId.orEmpty())
    }
    private fun updateGroupInfo(index: Int, groupIds: List<String>) {
        if (index < groupIds.size) {
            val groupId = groupIds[index]
            val group = findGroupById(groupId)
            if (group != null) {
                val groupNameId = when (index) {
                    0 -> R.id.tv_ctDetail_groupName
                    1 -> R.id.tv_ctDetail_groupName1
                    2 -> R.id.tv_ctDetail_groupName2
                    else -> throw RuntimeException()
                }

                val groupDescId = when (index) {
                    0 -> R.id.tv_ctDetail_groupDesc
                    1 -> R.id.tv_ctDetail_groupDesc1
                    2 -> R.id.tv_ctDetail_groupDesc2
                    else -> throw RuntimeException()
                }

                val groupPicId = when (index) {
                    0 -> R.id.iv_ctDetail_groupPic
                    1 -> R.id.iv_ctDetail_groupPic1
                    2 -> R.id.iv_ctDetail_groupPic2
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
        // 백 버튼을 눌렀을 때 MyContactsFragment 로 돌아 가기
        super.onBackPressed()
    }
}