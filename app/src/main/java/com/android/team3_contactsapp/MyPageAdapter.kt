package com.android.team3_contactsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.MypageRecyclerBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemContactBinding

class MyPageAdapter (val myItems : MutableList<MyJoinedGroup>): RecyclerView.Adapter<MyPageAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageAdapter.Holder {
        val binding = MypageRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder ,position: Int) {
        holder.mpImage.setImageResource(myItems[position].img)
        holder.mpName.text = myItems[position].name
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    inner class Holder(val binding: MypageRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        val mpImage = binding.mypageJoinedGroupImg
        val mpName = binding.mypageJoinedGroupName
    }
}