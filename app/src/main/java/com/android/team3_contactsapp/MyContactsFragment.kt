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
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.team3_contactsapp.databinding.FragmentMyContactsBinding
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

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

        val myContactsAdapter = MyContactsAdapter(Data.member[0].friendsPhoneNumbersId)
        binding.rvMyContactsList.adapter = myContactsAdapter
        binding.rvMyContactsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        myContactsAdapter.itemClick = object : MyContactsAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val id = Data.member[0].friendsPhoneNumbersId[position]
                val data = Data.member.find {
                    id == it.memberId
                }
                //Log.d("test", "onViewCreated data =  ${data}")
                if (data != null) {
                    listener?.onDataReceived(data)
                }
            }
        }

        myContactsAdapter.itemLongClick = object : MyContactsAdapter.ItemLongClick {
            override fun onLongClick(view: View, position: Int) {
                val ad = androidx.appcompat.app.AlertDialog.Builder(context!!)
                ad.setMessage("연락처를 삭제하시겠습니까?")
                ad.setPositiveButton("확인") { dialog, _ ->
                    val id = Data.member[0].friendsPhoneNumbersId[position]
                    val member = Data.member.find {
                        id == it.memberId
                    }
                    Log.d("test", "롱클릭 멤버 =  ${member}")
                    Data.member[0].friendsPhoneNumbersId.removeAt(position)
                    myContactsAdapter.notifyItemRemoved(position)
                    dialog.dismiss()
                }
                ad.setNegativeButton("취소"){ dialog,_ ->
                    dialog.dismiss()
                }
                ad.show()
            }
        }

        binding.ivAddContact.setOnClickListener {//

            val alertDialog : AlertDialog

            var builder = AlertDialog.Builder(context)
            builder.setTitle("연락처 추가하기")

            var view = layoutInflater.inflate(R.layout.dialog_addcontact, null)
            builder.setView(view)

            var listener = DialogInterface.OnClickListener { p0, p1 ->
                }

            builder.setPositiveButton("추가하기", listener)
            builder.setNegativeButton("취소", null)

            alertDialog = builder.create()
            alertDialog.show()

            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {p0 ->
                var closeDialog = false
                //val alert = p0 as AlertDialog
                val validationMessage: TextView = view.findViewById(R.id.tvValidationMessage)
                val name = view.findViewById<EditText>(R.id.et_dialog_name)
                val phone = view.findViewById<EditText>(R.id.et_dialog_phone)
                val email = view.findViewById<EditText>(R.id.et_dialog_email)

                if(name.text.isEmpty() || !isValidname(name.text.toString())){
                    validationMessage.text = "이름이 잘못되었습니다."
                    return@setOnClickListener
                } else if(phone.text.isEmpty() || !isValidPhoneNumber(phone.text.toString())){
                    validationMessage.text ="번호가 잘못되었습니다"
                    return@setOnClickListener
                } else if(!isValidEmail(email.text.toString())){
                    validationMessage.text = "메일이 잘못되었습니다."
                    return@setOnClickListener
                }

                if(name.text.isNotEmpty() && isValidname(name.text.toString()) && phone.text.isNotEmpty() && isValidPhoneNumber(phone.text.toString()) ){
                    closeDialog=true
                    val id = createId(name.text.toString())
                    Data.member.add(
                        Member(
                            id,
                            R.drawable.person,
                            name.text.toString(),
                            if(email.text.isNotEmpty()) email.text.toString() else "",
                            "신규회원",
                            0,
                            phone.text.toString(),
                            mutableListOf(),
                            mutableListOf(),
                            mutableListOf()
                        )
                    )
                    Data.member[0].friendsPhoneNumbersId.add(id)
                    Log.d("test","추가됨 ${name.text}, ${email.text}, ${phone.text} .${Data.member[0].friendsPhoneNumbersId}")

                }



                if (closeDialog) { // [닫기]
                    alertDialog.dismiss()
                }

            }
        }//
    }

    override fun onStart() {
        super.onStart()

        binding.rvMyContactsList.adapter?.notifyDataSetChanged()
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
        //Dialog.dismiss()
    }
    private fun createId(name:String): String{
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        var id = (1..10).map { charset.random() }.joinToString("")
        id+=name
        return id
    }

    private fun isValidname(name:String): Boolean {
        val nameRegex = """^(?=.*[A-Za-z가-힣\d])[A-Za-z가-힣\d]{1,24}$"""
        val namePattern = Pattern.compile(nameRegex)
        return namePattern.matcher(name).matches()
    }

    private fun isValidPhoneNumber (num : String) : Boolean {
        val phoneRegex = """^\d{10,11}${'$'}"""
        val namePattern = Pattern.compile(phoneRegex)
        return namePattern.matcher(num).matches()
    }

    private fun isValidEmail (email : String) : Boolean {
        val emailRegex = """\w+@\w+\.\w+(\.\w+)?"""
        val namePattern = Pattern.compile(emailRegex)
        when (email){
            "" -> return true
            else -> return namePattern.matcher(email).matches()
        }
    }

}