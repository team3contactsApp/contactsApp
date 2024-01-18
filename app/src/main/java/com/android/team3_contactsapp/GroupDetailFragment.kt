package com.android.team3_contactsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.FragmentGroupDetailBinding


class GroupDetailFragment : Fragment() {
    private var _binding : FragmentGroupDetailBinding? =null
    private val binding get() = _binding!!

    private var myData : Group ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            myData = it.getParcelable("key")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGroupDetailBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivGroupDetailImg.setImageResource(R.drawable.person)
        binding.tvGroupDesc.text = "설명"
        binding.tvGroupDetailName.text = "바다 사랑단"
        val memberids = Data.group.find {
            it.groupId == "group1"
        }!!.joinedMemberId
        val joinedMemberAdapter = JoinedMemberAdapter(memberids)
        binding.rvMemberList.adapter = joinedMemberAdapter
        binding.rvMemberList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GroupDetailBlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            GroupDetailFragment().apply {
                arguments = Bundle().apply {
                }
            }

        fun newInstance2(pram1: Group) =
            GroupDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("key", pram1)
                }
            }
    }
}