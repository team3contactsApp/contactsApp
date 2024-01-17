package com.android.team3_contactsapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemPeopleBinding


class PostAdapter(val mItems: MutableList<String>) : RecyclerView.Adapter<PostAdapter.Holder>() {
    inner class Holder(val binding: RecyclerviewItemPeopleBinding) : RecyclerView.ViewHolder(binding.root){
        val pImg = binding.ivPersonImg
        val pName = binding.tvPersonName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewItemPeopleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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
            holder.pImg.setImageResource(it.MemberImg)
            holder.pName.text = it.Name
        }

    }
}