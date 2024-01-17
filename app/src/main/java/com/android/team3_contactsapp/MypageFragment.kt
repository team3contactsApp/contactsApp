package com.android.team3_contactsapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.FragmentMypageBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MypageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        val view = binding.root

        //마이페이지 리사이클러뷰
        val MyPageAdapter = MyPageAdapter(Data.myJoinedgroup)
        binding.mypageRecyclerView.adapter = MyPageAdapter
        binding.mypageRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        //수정 다이어로그 생성
        binding.mypageClear.setOnClickListener {
            val dialogFragment = MyDialogFragment(this)
            dialogFragment.show(parentFragmentManager, "myDialog")
        }
        return view

    }


    fun updateInformation(name: String?, phoneNumber: String?, email: String?) {
        binding.mypageName.text = name
        binding.mypagePhonenumber.text = phoneNumber
        binding.mypageEmail.text = email

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MypageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
