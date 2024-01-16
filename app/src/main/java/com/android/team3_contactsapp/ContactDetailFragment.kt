package com.android.team3_contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.team3_contactsapp.databinding.FragmentContactDetailBinding

private const val ARG_NAME = "name"
private const val ARG_PHONE_NUMBER = "phone_number"
private const val ARG_MEMBER_IMG = "member_img"

class ContactDetailFragment : Fragment() {
    private var name: String? = null
    private var myPhoneNumber: String? = null
    private var memberImg: Int = 0
    private var _binding : FragmentContactDetailBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            myPhoneNumber = it.getString(ARG_PHONE_NUMBER)
            memberImg = it.getInt(ARG_MEMBER_IMG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactDetailBinding.inflate(inflater, container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.tvCtDetailName?.text = name

        binding?.btnMessage?.setOnClickListener {
            sendMessage(myPhoneNumber ?: "")
        }
        val memberImgPicture = ContextCompat.getDrawable(requireContext(), memberImg)
        binding?.ivCtDetailMyPicture?.setImageDrawable(memberImgPicture)

        binding?.btnCall?.setOnClickListener {
            sendCall(myPhoneNumber ?: "")
        }
    }

    private fun sendMessage(phoneNumber: String) {
        val message = "안녕하세요, {$phoneNumber}님에게 메세지를 전송합니다. "
        println("메세지 전송: $message")
    }

    private fun sendCall(phoneNumber: String) {
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, phoneNumber: String, memberIma: Int) =
            ContactDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_PHONE_NUMBER, phoneNumber)
                    putInt(ARG_MEMBER_IMG, memberIma)
                }
            }
    }
}