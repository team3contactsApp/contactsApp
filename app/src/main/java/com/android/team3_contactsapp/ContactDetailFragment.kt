package com.android.team3_contactsapp

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.team3_contactsapp.databinding.FragmentContactDetailBinding

private const val ARG_PARAM1 = "data"

class ContactDetailFragment : Fragment() {
    private var member: Member? = null
    private var _binding : FragmentContactDetailBinding? = null
    private val binding get() = _binding

    private val fixedPhoneNumber = "01012345678"


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            member = it.getParcelable("data",Member::class.java)
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

        binding?.tvCtDetailName?.text = "홍길동"

        binding?.btnMessage?.setOnClickListener {
            sendMessage(fixedPhoneNumber)
        }

        binding?.btnCall?.setOnClickListener {
            sendCall(fixedPhoneNumber)
        }
    }

    private fun sendMessage(phoneNumber: String) {
        Toast.makeText(requireContext(), "메세지 전송 중: $phoneNumber", Toast.LENGTH_SHORT).show()
    }

    private fun sendCall(phoneNumber: String) {
        Toast.makeText(requireContext(), "전화 걸기 중: $phoneNumber", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1:Bundle) =
            ContactDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }
}