package com.android.team3_contactsapp

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.android.team3_contactsapp.databinding.ClearDialogBinding

class MyDialogFragment(val mypageFragment: MypageFragment) : DialogFragment() {

    private var _binding: ClearDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ClearDialogBinding.inflate(inflater, container, false)
        val customView = binding.root

        val builder = AlertDialog.Builder(requireActivity())

        // 커스텀 뷰 설정
        builder.setView(customView)

        val edit1: EditText? = customView.findViewById(R.id.editText)
        val edit2: EditText? = customView.findViewById(R.id.editText2)
        val edit3: EditText? = customView.findViewById(R.id.editText3)
        binding.btnOkay.setOnClickListener {
            val name = edit1?.text.toString()
            val phoneNumber = edit2?.text.toString()
            val email = edit3?.text.toString()

            if (!isValidName(name)) {
                Toast.makeText(requireContext(), "이름이 잘못 되었습니다.", Toast.LENGTH_SHORT).show()
                binding.tvErrorName.visibility = View.VISIBLE
                return@setOnClickListener
            }

            if (!isValidPhoneNumber(phoneNumber)) {
                Toast.makeText(requireContext(), "전화번호 입력이 잘못 되었습니다.", Toast.LENGTH_SHORT).show()
                binding.tvErrorName.visibility = View.VISIBLE
                binding.tvErrorName.text = "전화번호는 숫자만 입력이 가능합니다."
                return@setOnClickListener
            }

            if (!isValidEmail(email)) {
                binding.tvErrorName.visibility = View.VISIBLE
                binding.tvErrorName.text = "이메일입력은 aaa@bbb.ccc 형식을 지켜주세요"
                return@setOnClickListener }
            else {
                mypageFragment.updateInformation(
                    edit1?.text.toString(),
                    edit2?.text.toString(),
                    edit3?.text.toString()
                )
                dismiss()
            }
        }
        binding.btnCancle.setOnClickListener() {
            dismiss()
        }
        return customView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isValidName(editText: String): Boolean {
        val modifynameRegex = Regex("^[a-zA-Z가-힣0-9]+$")
        return modifynameRegex.matches(editText)
    }

    private fun isValidPhoneNumber(editText2: String): Boolean {
        val modifyphoneNumber = Regex("^(010|011)[0-9]{3,4}[0-9]{4}$")
        return modifyphoneNumber.matches(editText2)
    }

    private fun isValidEmail(editText3: String): Boolean {
        val modifyEmail = Regex("^[a-zA-Z0-9]{3,}+@[a-zA-Z0-9]+\\.[a-zA-Z]{1,}\$")
        return modifyEmail.matches(editText3)

    }
}


