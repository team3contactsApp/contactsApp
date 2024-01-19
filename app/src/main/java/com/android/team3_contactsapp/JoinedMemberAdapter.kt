package com.android.team3_contactsapp


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemPeopleBinding
import com.android.team3_contactsapp.group_recycler.GroupRecyclerAdapter1


class JoinedMemberAdapter(val mItems: MutableList<String>) : RecyclerView.Adapter<JoinedMemberAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

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
        Log.d("test","그룹상세페이지 멤버는 ${member}")
        member?.let {
            holder.itemView.setOnClickListener {view ->
                itemClick?.onClick(view,holder.adapterPosition)
            }
            holder.pImg.setImageResource(it.MemberImg)
            holder.pName.text = it.Name
        }

    }
}