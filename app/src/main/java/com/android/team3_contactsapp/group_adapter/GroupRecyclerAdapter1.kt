package com.android.team3_contactsapp.group_recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.Data
import com.android.team3_contactsapp.Group
import com.android.team3_contactsapp.MainActivity
import com.android.team3_contactsapp.Member
import com.android.team3_contactsapp.R
import com.android.team3_contactsapp.databinding.FragmentGroupBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemGroupBinding
import com.android.team3_contactsapp.group_adapter.GroupRecyclerAdapter2

class GroupRecyclerAdapter1(private val dataList: MutableList<Group>) :
    RecyclerView.Adapter<GroupRecyclerAdapter1.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    inner class Holder(private val binding: RecyclerviewItemGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(data : Group) {
            binding.ivGroupImg.setImageResource(data.groupImg)
            binding.tvGroupName.text = data.groupName

            binding.recyclerView2.apply {
                val myAdapter = GroupRecyclerAdapter2(data.joinedMemberId)
                adapter = myAdapter
                myAdapter.itemClick = object : GroupRecyclerAdapter2.ItemClick {
                    override fun onClick(view: View, position: Int) {


                    }
                }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = RecyclerviewItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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