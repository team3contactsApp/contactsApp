package com.android.team3_contactsapp



import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemContactBinding


class MyContactsAdapter (val mItems: MutableList<String>) : RecyclerView.Adapter<MyContactsAdapter.Holder>() {
    inner class Holder(val binding: RecyclerviewItemContactBinding) : RecyclerView.ViewHolder(binding.root){
        val personImg = binding.ivPersonImg
        val personName = binding.tvPersonName
        val personLike = binding.ivLike
    }

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewItemContactBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
       return mItems.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val member = Data.member.find {
            it.memberId==mItems[position]
        }
        //Log.d("test","member는 ${member} ")
        member?.let {
            //Log.d("test","let 안에 있는 member는 ${it} ")
            holder.itemView.setOnClickListener {view ->
                itemClick?.onClick(view,holder.adapterPosition)
                Log.d("test","11adapterposioin  ${holder.adapterPosition} ")
            }

            if( Data.member[0].likeIdList.contains(it.memberId)){
                holder.personLike.setImageResource(R.drawable.heartfill)
                holder.personLike.tag = "hearfill"
            } else {
                holder.personLike.setImageResource(R.drawable.heart)
                holder.personLike.tag = "heart"
            }

            holder.personImg.setImageResource(it.MemberImg)
            holder.personName.text = it.Name

            holder.personLike.setOnClickListener {view ->
                if(holder.personLike.tag=="heart"){
                    holder.personLike.setImageResource(R.drawable.heartfill)
                    holder.personLike.tag = "hearfill"
                    Data.member[0].likeIdList.add(it.memberId)
                    Log.d("test","좋아요 리스트 추가확인 ${Data.member[0].likeIdList}")
                } else {
                    holder.personLike.setImageResource(R.drawable.heart)
                    holder.personLike.tag = "heart"
                    Data.member[0].likeIdList.removeIf {str ->
                        str == it.memberId
                    }
                    Log.d("test","좋아요 리스트 삭제확인 ${Data.member[0].likeIdList}")
                }
            }

        }


    }
}
