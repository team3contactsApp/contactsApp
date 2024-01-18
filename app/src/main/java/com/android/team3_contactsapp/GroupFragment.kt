package com.android.team3_contactsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.ActivityGroupDetailBinding
import com.android.team3_contactsapp.databinding.ActivityMainBinding
import com.android.team3_contactsapp.databinding.FragmentGroupBinding
import com.android.team3_contactsapp.group_recycler.GroupRecyclerAdapter1

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GroupFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    //private lateinit var intent: Intent
    private lateinit var binding: FragmentGroupBinding
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
        //return inflater.inflate(R.layout.fragment_group, container, false)
        binding = FragmentGroupBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val joinedGroupAdapter = JoinedGroupAdapter(Data.myJoinedgroup)
        binding.rvMyGroupList.adapter = joinedGroupAdapter
        binding.rvMyGroupList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val groupAdapter = GroupRecyclerAdapter1(Data.group)
        binding.recyclerView1.adapter = groupAdapter

        groupAdapter.itemClick = object : GroupRecyclerAdapter1.ItemClick {
            override fun onClick(view: View, position: Int) {

                val mainActivityView = (activity as MainActivity)
                mainActivityView.setGroupDetailFragment(Data.group[position])

            }
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GroupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}