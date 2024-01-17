package com.android.team3_contactsapp.group_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.team3_contactsapp.Group
import com.android.team3_contactsapp.databinding.RecyclerviewItemGroupBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding

class GroupRecyclerAdapter2(private val dataList: MutableList<String>) : RecyclerView.Adapter<GroupRecyclerAdapter2.Holder>(){

    inner class Holder(private val binding: RecyclerviewItemJoinedgroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.ivJoinedGroupImg
            binding.tvJoinedGroupName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = RecyclerviewItemJoinedgroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(itemView)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

    }
}