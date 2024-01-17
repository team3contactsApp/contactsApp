package com.android.team3_contactsapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.FragmentMyContactsBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

interface FragmentDataListener {
    fun onDataReceived(data: Member)
}

class MyContactsFragment : Fragment() {

    private var _binding: FragmentMyContactsBinding? = null
    private val binding get() = _binding!!

    private var listener: FragmentDataListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentDataListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement FragmentDataListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val joinedGroupAdapter = JoinedGroupAdapter(Data.myJoinedgroup)
        val myContactsAdapter = MyContactsAdapter(Data.myContacts)
        binding.rvMyGroupList.adapter = joinedGroupAdapter
        binding.rvMyGroupList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMyContactsList.adapter = myContactsAdapter
        binding.rvMyContactsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        myContactsAdapter.itemClick = object : MyContactsAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val data = Data.member[position]
                Log.d("test", "onViewCreated data =  ${data}")
                listener?.onDataReceived(data)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MyContactsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        listener = null
    }
}