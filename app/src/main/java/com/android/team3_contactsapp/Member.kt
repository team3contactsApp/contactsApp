package com.android.team3_contactsapp


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Member(
    var memberId: String,
    var MemberImg: Int,
    var Name: String,
    var email: String,
    var actCnt: Int,
    var title: String,
    var myPhoneNumber: String,
    var joinedGroupId: MutableList<String>,
    var phoneNumbers: MutableList<Int>
) : Parcelable

@Parcelize
data class MyContacts(
    var name : String,
    var email : String,
    var img : Int
) : Parcelable

@Parcelize
data class MyJoinedGroup(
    var name : String,
    var img : Int
) : Parcelable

@Parcelize
data class Group(
    val groupId: String,
    var groupImg: Int,
    var groupName: String,
    var groupDesc: String,
    var joinedMemberId: MutableList<String>,
    var posts: MutableList<Post>
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