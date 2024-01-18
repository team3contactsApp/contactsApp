package com.android.team3_contactsapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.FragmentMypageBinding
import java.util.Calendar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MypageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!
    private val initialItemCount = Data.myJoinedgroup.size

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
        val MyPageAdapter = MyPageAdapter(Data.myJoinedgroup)

        //마이페이지 리사이클러뷰
        binding.mypageRecyclerView.adapter = MyPageAdapter
        binding.mypageRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        //아이템 클릭처리
        MyPageAdapter.itemClick = object : MyPageAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val clickedItem = Data.myJoinedgroup[position]
                Toast.makeText(
                    requireContext(),
                    "${clickedItem.name}이 선택 되었습니다.",
                    Toast.LENGTH_SHORT
                ).show()

                //항목 선택 시 알림 설정 Fragment 열기
                val notifyDialogFragment = NotificationDialogFragment(this@MypageFragment)
                notifyDialogFragment.show(childFragmentManager, "NotificationDialog")
            }
        }

        //날짜 다이어로그 띄우기
        binding.btnDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener = DatePickerDialog.OnDateSetListener { datePICKER, i, i2, i3 ->
                binding.tvDate.text = "${i}년 ${i2 + 1}월 ${i3}일"
            }
            var picker = DatePickerDialog(requireContext(), listener, year, month, day)
            picker.show()
        }

        //시간 다이어로그 띄우기
        binding.btnTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val listener = TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->

                binding.tvTime.text = "${i}시 ${i2}분"
            }
            val picker = TimePickerDialog(requireContext(), listener, hour, minute, false)
            picker.show()
        }

        //모임 그룹 개수에 따른 활동 횟수 증가
        binding.activityCount.text = "${initialItemCount}"

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