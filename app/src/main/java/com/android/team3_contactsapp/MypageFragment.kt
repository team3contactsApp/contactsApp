package com.android.team3_contactsapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.android.team3_contactsapp.databinding.FragmentMypageBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MypageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val binding by lazy { FragmentMypageBinding.inflate(layoutInflater) }

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        binding.mypageClear.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.drawable.seedimage)

            val v1 = layoutInflater.inflate(R.layout.clear_dialog, null)
            builder.setView(v1)

            val listener = DialogInterface.OnClickListener { p0, p1 ->
                val alert = p0 as AlertDialog

                val edit1: EditText? = alert.findViewById(R.id.editText)
                val edit2: EditText? = alert.findViewById(R.id.editText2)
                val edit3: EditText? = alert.findViewById(R.id.editText3)

                binding.mypageName.text = edit1?.text.toString()
                binding.mypagePhonenumber.text = edit2?.text.toString()
                binding.mypageEmail.text = edit3?.text.toString()
            }

            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", null)

            builder.show()
        }
        return view
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