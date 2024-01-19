package com.android.team3_contactsapp


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Member(
    var memberId: String,
    var MemberImg: Int,
    var Name: String,
    var email: String,
    var title: String,
    var actCnt : Int,
    var myPhoneNumber: String,
    var joinedGroupId: MutableList<String>,
    var friendsPhoneNumbersId: MutableList<String>,
    var likeIdList:MutableList<String>
) : Parcelable

@Parcelize
data class MyContacts(
    val id : String,
    var name : String,
    var email : String,
    var img : Int
) : Parcelable

@Parcelize
data class MyJoinedGroup(
    var name : String,
    var img : Int,
    var groupId : String ?= null
) : Parcelable

@Parcelize
data class Group(
    val groupId: String,
    var groupImg: Int,
    var groupName: String,
    var groupDesc: String,
    var joinedMemberId: MutableList<String>
) : Parcelable

@Parcelize
data class Post(
    val postId: String,
    var postImg: Int,
    var postName: String,
    var postContent: String,
    var writer: String,
    var views: Int
) : Parcelable