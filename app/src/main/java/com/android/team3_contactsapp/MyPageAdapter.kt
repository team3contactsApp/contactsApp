package com.android.team3_contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.MypageRecyclerBinding

class MyPageAdapter (val myItems : MutableList<String>): RecyclerView.Adapter<MyPageAdapter.Holder>() {


    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageAdapter.Holder {
        val binding = MypageRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder ,position: Int) {
        val group = Data.group.find {
            it.groupId==myItems[position]
        }
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        group?.let {
            holder.mpImage.setImageResource(it.groupImg)
            holder.mpName.text = it.groupName
        }
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    inner class Holder(val binding: MypageRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        val mpImage = binding.mypageJoinedGroupImg
        val mpName = binding.mypageJoinedGroupName
    }
}