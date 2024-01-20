package com.android.team3_contactsapp



import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.Callback.getDefaultUIUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.team3_contactsapp.databinding.RecyclerviewItemContact2Binding
import com.android.team3_contactsapp.databinding.RecyclerviewItemContactBinding


class MyContactsAdapter (val mItems: MutableList<String>,vt: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val viewType = vt
    inner class Holder(val binding: RecyclerviewItemContactBinding) : RecyclerView.ViewHolder(binding.root){
        val personImg = binding.ivPersonImg
        val personName = binding.tvPersonName
        val personLike = binding.ivLike
        val personLayout = binding.constraintlayoutSwipe
        val personPhone = binding.tvContactPhone
        fun bind(item: Member){
            personImg.setImageResource(item.MemberImg)
            personName.text = item.Name
            if( Data.member[0].likeIdList.contains(item.memberId)){
                personLike.setImageResource(R.drawable.heartfill)
                personLike.tag = "hearfill"
            } else {
                personLike.setImageResource(R.drawable.heart)
                personLike.tag = "heart"
            }
        }
    }
    inner class HolderGrid(val binding: RecyclerviewItemContact2Binding) : RecyclerView.ViewHolder(binding.root){
        val personImg2 = binding.ivPersonImg
        val personName2 = binding.tvPersonName
        val personLike2 = binding.ivLike
        fun bind(item: Member){
            personImg2.setImageResource(item.MemberImg)
            personName2.text = item.Name
            if( Data.member[0].likeIdList.contains(item.memberId)){
                personLike2.setImageResource(R.drawable.heartfill)
                personLike2.tag = "hearfill"
            } else {
                personLike2.setImageResource(R.drawable.heart)
                personLike2.tag = "heart"
            }
        }
    }

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }
    interface ItemLongClick {
        fun onLongClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == Constants.LIST){
            //Log.d("test","holderlist")
            val binding = RecyclerviewItemContactBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return Holder(binding)
        }else{
            //Log.d("test","holdergrid")

            val bindingGrid = RecyclerviewItemContact2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
            return HolderGrid(bindingGrid)
        }

    }

    override fun getItemCount(): Int {
       return mItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = Data.member.find {
            it.memberId==mItems[position]
        }

        when(viewType){
            1 -> {
                val listHolder = holder as Holder

                member?.let {
                    Log.d("test","list let 안에 있는 member는 ${it} ")

                    listHolder.itemView.setOnClickListener { view ->
                        itemClick?.onClick(view,listHolder.adapterPosition)
                        Log.d("test","shortclick ,${viewType}, ${holder.adapterPosition} ")
                    }
                    listHolder.itemView.setOnLongClickListener() OnLongClickListener@ {view ->
                        itemLongClick?.onLongClick(view, listHolder.adapterPosition)
                        Log.d("test","longclick  ${holder.adapterPosition} ")
                        return@OnLongClickListener true
                    }

                    if( Data.member[0].likeIdList.contains(it.memberId)){
                        listHolder.personLike.setImageResource(R.drawable.heartfill)
                        listHolder.personLike.tag = "hearfill"
                    } else {
                        listHolder.personLike.setImageResource(R.drawable.heart)
                        listHolder.personLike.tag = "heart"
                    }

                    listHolder.personImg.setImageResource(it.MemberImg)
                    listHolder.personName.text = it.Name
                    listHolder.personPhone.text = it.myPhoneNumber

                    listHolder.personLike.setOnClickListener {view ->
                        if(listHolder.personLike.tag=="heart"){
                            listHolder.personLike.setImageResource(R.drawable.heartfill)
                            listHolder.personLike.tag = "hearfill"
                            Data.member[0].likeIdList.add(it.memberId)
                            //Log.d("test","좋아요 리스트 추가확인 ${Data.member[0].likeIdList}")
                        } else {
                            listHolder.personLike.setImageResource(R.drawable.heart)
                            listHolder.personLike.tag = "heart"
                            Data.member[0].likeIdList.removeIf {str ->
                                str == it.memberId
                            }
                            //Log.d("test","좋아요 리스트 삭제확인 ${Data.member[0].likeIdList}")
                        }
                    }

                }
            }
            2 -> {
                val gridHolder = holder as HolderGrid

                member?.let {
                    Log.d("test","grid let 안에 있는 member는 ${it}  ")
                    gridHolder.itemView.setOnClickListener { view ->
                        itemClick?.onClick(view,gridHolder.adapterPosition)
                        Log.d("test","shortclick ,${viewType}, ${holder.adapterPosition} ")
                    }
                    gridHolder.itemView.setOnLongClickListener() OnLongClickListener@ {view ->
                        itemLongClick?.onLongClick(view, gridHolder.adapterPosition)
                        Log.d("test","longclick  ${holder.adapterPosition} ")
                        return@OnLongClickListener true
                    }

                    if( Data.member[0].likeIdList.contains(it.memberId)){
                        gridHolder.personLike2.setImageResource(R.drawable.heartfill)
                        gridHolder.personLike2.tag = "hearfill"
                    } else {
                        gridHolder.personLike2.setImageResource(R.drawable.heart)
                        gridHolder.personLike2.tag = "heart"
                    }

                    gridHolder.personImg2.setImageResource(it.MemberImg)
                    gridHolder.personName2.text = it.Name

                    gridHolder.personLike2.setOnClickListener {view ->
                        if(gridHolder.personLike2.tag=="heart"){
                            gridHolder.personLike2.setImageResource(R.drawable.heartfill)
                            gridHolder.personLike2.tag = "hearfill"
                            Data.member[0].likeIdList.add(it.memberId)
                            Log.d("test","좋아요 리스트 추가확인 ${Data.member[0].likeIdList}")
                        } else {
                            gridHolder.personLike2.setImageResource(R.drawable.heart)
                            gridHolder.personLike2.tag = "heart"
                            Data.member[0].likeIdList.removeIf {str ->
                                str == it.memberId
                            }
                            Log.d("test","좋아요 리스트 삭제확인 ${Data.member[0].likeIdList}")
                        }
                    }

                }
            }
        }



    }
}



class MyContactSwipeHelper(val con:Context) //listener: ItemTouchHelperListener
    : ItemTouchHelper.Callback() {
    // 활성화된 이동 방향을 정의하는 플래그를 반환하는 메소드
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0, ItemTouchHelper.RIGHT)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    // 사용자에 의해 swipe될 때 호출
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val contactViewHolder = viewHolder as MyContactsAdapter.Holder
        val phone = contactViewHolder.personPhone.text

        if (direction == ItemTouchHelper.RIGHT) {
            val callUri = Uri.parse("smsto:$phone")
            val intent = Intent(Intent.ACTION_SENDTO, callUri)

            con.startActivity(intent)

        }

    }




    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
            val view = (viewHolder as MyContactsAdapter.Holder).personLayout
            getDefaultUIUtil().onDraw(c,recyclerView,view,dX,dY,actionState,isCurrentlyActive)
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        getDefaultUIUtil().clearView((viewHolder as MyContactsAdapter.Holder).personLayout )
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }
}