package com.android.team3_contactsapp.group_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.team3_contactsapp.Data
import com.android.team3_contactsapp.Group
import com.android.team3_contactsapp.databinding.RecyclerviewItemGroupBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding

class GroupRecyclerAdapter2(private val dataList: MutableList<String>) : RecyclerView.Adapter<GroupRecyclerAdapter2.Holder>(){

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    inner class Holder(private val binding: RecyclerviewItemJoinedgroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(str: String) {
            binding.ivJoinedGroupImg.setImageResource(Data.member[str.toInt()-1].MemberImg)
            binding.tvJoinedGroupName.setText(Data.member[str.toInt()-1].Name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = RecyclerviewItemJoinedgroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(itemView)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        dataList[position].run { holder.bind(this) }
    }
}