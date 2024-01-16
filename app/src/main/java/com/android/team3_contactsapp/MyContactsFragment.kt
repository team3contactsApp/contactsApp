package com.android.team3_contactsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.FragmentMyContactsBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyContactsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentMyContactsBinding? = null
    private val binding get() = _binding!!

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
        binding.rvMyGroupList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.rvMyContactsList.adapter = myContactsAdapter
        binding.rvMyContactsList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyContactsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyContactsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}