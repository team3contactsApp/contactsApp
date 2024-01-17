package com.android.team3_contactsapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.team3_contactsapp.databinding.FragmentContactDetailBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactDetailFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentContactDetailBinding? = null
    private val binding get() = _binding

    private val fixedPhoneNumber = "01012345678"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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
        fun newInstance(param1: String, param2: String) =
            ContactDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}