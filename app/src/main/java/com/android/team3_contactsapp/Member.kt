package com.android.team3_contactsapp

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Email
import kotlinx.parcelize.Parcelize

@Parcelize
data class Member(
    var MemberImg : Int,
    var Name : String,
    var email: String,
    var actCnt: Int,
    var title : String,
    var phoneNumber : String,
    var joinedGroup:ArrayList<Group>
) : Parcelable