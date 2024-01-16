package com.android.team3_contactsapp

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.FragmentMyContactsBinding
import com.android.team3_contactsapp.databinding.RecyclerviewItemJoinedgroupBinding
import kotlinx.parcelize.Parcelize

@Parcelize
data class Group(
    var groupImg : Int,
    var groupName : String,
    var groupDesc: String,
    var members: ArrayList<Member>,
    var posts : ArrayList<Post>
) : Parcelable

@Parcelize
data class Post(
    var postImg : Int,
    var postName : String,
    var postContent: String,
    var writer: String,
    var views : Int
) : Parcelable
class JoinedGroupAdapter(val mItems: MutableList<Group>) : RecyclerView.Adapter<JoinedGroupAdapter.Holder>() {
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
        holder.groupImg.setImageResource(mItems[position].groupImg)
        holder.groupName.text = mItems[position].groupName
    }
}