package com.android.team3_contactsapp


import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemContactBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding
import kotlinx.parcelize.Parcelize


class MyContactsAdapter (val mItems: MutableList<String>) : RecyclerView.Adapter<MyContactsAdapter.Holder>() {
    inner class Holder(val binding: RecyclerviewItemContactBinding) : RecyclerView.ViewHolder(binding.root){
        val personImg = binding.ivPersonImg
        val personName = binding.tvPersonName
    }

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewItemContactBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
       return mItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val member = Data.member.find {
            it.memberId==mItems[position]
        }
        member?.let {
            holder.itemView.setOnClickListener {view ->
                itemClick?.onClick(view,position)
            }
            holder.personImg.setImageResource(it.MemberImg)
            holder.personName.text = it.Name
        }
    }
}