package com.android.team3_contactsapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding



class JoinedGroupAdapter(val mItems: MutableList<MyJoinedGroup>) : RecyclerView.Adapter<JoinedGroupAdapter.Holder>() {
    inner class Holder(val binding: RecyclerviewItemJoinedgroupBinding) : RecyclerView.ViewHolder(binding.root){
        val groupImg = binding.ivJoinedGroupImg
        val groupName = binding.tvJoinedGroupName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewItemJoinedgroupBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
       return mItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //val imgsource = mItems[position].members
        holder.groupImg.setImageResource(mItems[position].img)
        holder.groupName.text = mItems[position].name
    }
}