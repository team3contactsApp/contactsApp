package com.android.team3_contactsapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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
        val myContactsAdapter = MyContactsAdapter(Data.member[0].friendsPhoneNumbersId)
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
        binding.ivAddContact.setOnClickListener {
            var builder = AlertDialog.Builder(context)
            builder.setTitle("연락처 추가하기")

            var view = layoutInflater.inflate(R.layout.dialog_addcontact, null)
            builder.setView(view)

            var listener = DialogInterface.OnClickListener { p0, p1 ->
                val alert = p0 as AlertDialog
                val name = alert.findViewById<EditText>(R.id.et_dialog_name)
                val phone = alert.findViewById<EditText>(R.id.et_dialog_phone)
                val email = alert.findViewById<EditText>(R.id.et_dialog_email)

                val id = createId(name.text.toString())
                Data.member.add(
                    Member(
                        id,
                        R.drawable.person,
                        name.text.toString(),
                        if(email.text.isNotEmpty()) email.text.toString() else "",
                        0,
                        "신규회원",
                        phone.text.toString(),
                        mutableListOf(),
                        mutableListOf()
                    )
                )
                Data.member[0].friendsPhoneNumbersId.add(id)
                Log.d("test","추가됨 ${name.text}, ${email.text}, ${phone.text} .${Data.member[0].friendsPhoneNumbersId}")
            }

            builder.setPositiveButton("추가하기", listener)
            builder.setNegativeButton("취소", null)

            builder.show()
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
    fun createId(name:String): String{
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        var id = (1..10).map { charset.random() }.joinToString("")
        id+=name
        return id
    }

}