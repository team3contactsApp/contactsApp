package com.android.team3_contactsapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.android.team3_contactsapp.databinding.ClearDialogBinding
import com.android.team3_contactsapp.databinding.FragmentGroupDetailBinding
import com.android.team3_contactsapp.databinding.FragmentMypageBinding

class MyDialogFragment(private val mypageFragment: MypageFragment) : DialogFragment() {

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
            mypageFragment.updateInformation(
                edit1?.text.toString(),
                edit2?.text.toString(),
                edit3?.text.toString()
            )
            dismiss()
        }
        return customView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}