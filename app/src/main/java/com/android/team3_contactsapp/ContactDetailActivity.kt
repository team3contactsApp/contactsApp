package com.android.team3_contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.ActivityContactDetailBinding

class ContactDetailActivity : AppCompatActivity(), UpdateInfoListener{
    private lateinit var binding: ActivityContactDetailBinding
    private var member: Member? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("data")
        member = bundle?.getParcelable("key", Member::class.java)
        //member =intent.getParcelableExtra("data",Member::class.java)

        val backButton: ImageView = findViewById(R.id.iv_back)
        backButton.setOnClickListener {
            onBackPressed()
        }

        binding.tvCtDetailName.text = member?.Name
        binding.ivCtDetailMyPicture.setImageResource(member?.MemberImg ?: 0)
        binding.tvCtDetailMobileNum.text = member?.myPhoneNumber
        binding.tvCtDetailNatureNum.text = member?.actCnt.toString()
        binding.tvCtDetailNatureName.text = member?.title
        binding.tvCtDetailGroupNameGroup.text = "${member?.Name}님이 가입한 모임들"

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

        binding. ctDetailClear.setOnClickListener {
            showUpdateDialog()
        }

        ctJoinedGroupAdapter.itemClick = object : MyContactsAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val groupId = Data.member[0].joinedGroupId[position]
                val data = Data.group.find {
                    groupId == it.groupId
                }
                Log.d("test", "onViewCreated data =  ${data}")
                val intent = Intent(this@ContactDetailActivity,GroupDetailActivity::class.java)
                intent.putExtra("Minyong",data)
                startActivity(intent)
            }
        }
    }

    private fun showUpdateDialog() {
        val dialogView =
            LayoutInflater.from(this).inflate(R.layout.dialog_update_info, null)
        val nameEditText: EditText = dialogView.findViewById(R.id.editTextName)
        val phoneNumEditText: EditText = dialogView.findViewById(R.id.editTextPhone)
        val validationMessage: TextView = dialogView.findViewById(R.id.tvValidationMessage)

        nameEditText.setText(member?.Name)
        phoneNumEditText.setText(member?.myPhoneNumber)

        phoneNumEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

                if (s != null && s.length ==4 && s[3] != '-') {
                    s.insert(3, "-")
                } else if (s != null && s.length ==9 && s[8] != '-') {
                    s.insert(8,"-")
                } else if (s != null && s.length == 9 && s[8] == '-') {
                    s.delete(8, 9)
                } else if (s != null && s.length == 4 && s[3] == '-') {
                    s.delete(3, 4)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("정보 수정")
            .setPositiveButton("확인") { dialog, _ ->
                val newName = nameEditText.text.toString()
                val newPhoneNum = phoneNumEditText.text.toString()

                val isNameValid = isValidName(newName)
                val isPhoneNumValid = isValidPhoneNumber(newPhoneNum)

                if (isNameValid && isPhoneNumValid) {
                    member?.apply {
                        Name = newName
                        myPhoneNumber = newPhoneNum
                    }

                    binding.tvCtDetailName.text = newName
                    binding.tvCtDetailMobileNum.text = newPhoneNum
                    binding.tvCtDetailGroupNameGroup.text = "${newName}님이 가입한 모임들"
                    onUpdateInfo(newName, newPhoneNum)
                    dialog.dismiss()
                } else {
                    var validationError = ""

                    if (!isNameValid) {
                        validationError = "이름이 잘못되었습니다."
                        nameEditText.requestFocus()
                    } else if (!isPhoneNumValid) {
                        validationError = "번호가 잘못되었습니다."
                        phoneNumEditText.requestFocus()
                    }

                    validationMessage.text = validationError
                    validationMessage.visibility = View.VISIBLE
                }
            }
            .setNegativeButton("취소") { dialog, _ ->
                dialog.dismiss()
            }

        val alertDialog = alertDialogBuilder.show()

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            val newName = nameEditText.text.toString()
            val newPhoneNum = phoneNumEditText.text.toString()

            if (isValidInput(newName, newPhoneNum)) {
                //
                Data.member.find {
                    it.memberId == member?.memberId
                }!!.let{ it2 ->
                    it2.Name = newName
                    it2.myPhoneNumber = newPhoneNum
                }

                binding.tvCtDetailName.text =newName
                binding.tvCtDetailMobileNum.text = newPhoneNum
                binding.tvCtDetailGroupNameGroup.text = "${newName}님이 가입한 모임"
                onUpdateInfo(newName, newPhoneNum)
                alertDialog.dismiss()
            } else {
                var validationError = ""

                if (!isValidName(newName)) {
                    validationError += "이름이 잘못되었습니다."
                    nameEditText.requestFocus()
                }

                if (!isValidPhoneNumber(newPhoneNum)) {
                    validationError += "번호가 잘못되었습니다."
                    phoneNumEditText.requestFocus()
                }

                validationMessage.text = validationError.trim()
                validationMessage.visibility = View.VISIBLE

                if (validationError.isEmpty()) {
                    validationMessage.visibility = View.GONE
                    alertDialog.dismiss()
                }
            }
        }
    }

    private fun isValidInput(name: String, phoneNumber: String): Boolean {
        return isValidName(name) && isValidPhoneNumber(phoneNumber)
    }

    private fun isValidNameOrPhoneNumber(value: String, regex: Regex): Boolean {
        return value.isNotEmpty() && regex.matches(value)
    }

    private fun isValidName(name: String): Boolean {
        val nameRegex = Regex("^[a-zA-Z가-힣0-9]+$")
        return isValidNameOrPhoneNumber(name, nameRegex)
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phoneNumberRegex = Regex("^(010|011)-[0-9]{3,4}-[0-9]{4}$")
        return phoneNumber.matches(phoneNumberRegex)
    }

    override fun onUpdateInfo(newName: String, newPhoneNum: String) {
        binding.tvCtDetailName.text = newName
        binding.tvCtDetailMobileNum.text = newPhoneNum
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
}