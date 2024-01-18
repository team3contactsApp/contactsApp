package com.android.team3_contactsapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemContactDetailJoinedgroupBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemPeopleBinding


class ContactDetailJoinedGroupAdapter(val mItems: MutableList<String>) : RecyclerView.Adapter<ContactDetailJoinedGroupAdapter.Holder>() {
    inner class Holder(val binding: RecyclerviewItemContactDetailJoinedgroupBinding) : RecyclerView.ViewHolder(binding.root){
        val gImg = binding.ivDetailGroupPic
        val gName = binding.tvDetailGroupName
        val gDesc = binding.tvDetailGroupDesc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewItemContactDetailJoinedgroupBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val group = Data.group.find {
            it.groupId==mItems[position]
        }
        group?.let {
            holder.gImg.setImageResource(it.groupImg)
            holder.gName.text = it.groupName
            holder.gDesc.text = it.groupDesc
        }

    }
}