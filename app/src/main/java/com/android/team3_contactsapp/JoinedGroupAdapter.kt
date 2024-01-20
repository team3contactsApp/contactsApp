package com.android.team3_contactsapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding



class JoinedGroupAdapter(val mItems: MutableList<String>) : RecyclerView.Adapter<JoinedGroupAdapter.Holder>() {
    inner class Holder(val binding: RecyclerviewItemJoinedgroupBinding) : RecyclerView.ViewHolder(binding.root){
        val groupImg = binding.ivJoinedGroupImg
        val groupName = binding.tvJoinedGroupName
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewItemJoinedgroupBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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
            holder.groupImg.setImageResource(it.groupImg)
            holder.groupName.text = it.groupName
            holder.itemView.setOnClickListener {view ->
                itemClick?.onClick(view,holder.adapterPosition)
                //Log.d("test","11adapterposioin  ${holder.adapterPosition} ")
            }
        }

    }
}