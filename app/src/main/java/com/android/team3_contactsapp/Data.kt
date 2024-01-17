package com.android.team3_contactsapp

object Data {
    val myContacts = mutableListOf(
        MyContacts("member1","사람이름1","1234@gmail.com",R.drawable.person),
        MyContacts("member2","사람이름2","1234@gmail.com",R.drawable.person),
        MyContacts("member3","사람이름3","1234@gmail.com",R.drawable.person),
        MyContacts("member4","사람이름4","1234@gmail.com",R.drawable.person),
        MyContacts("member5","사람이름5","1234@gmail.com",R.drawable.person),
        MyContacts("member6","사람이름6","1234@gmail.com",R.drawable.person),
        MyContacts("member7","사람이름7","1234@gmail.com",R.drawable.person),
        MyContacts("member8","사람이름8","1234@gmail.com",R.drawable.person),
        MyContacts("member9","사람이름9","1234@gmail.com",R.drawable.person),
        MyContacts("member10","사람이름10","1234@gmail.com",R.drawable.person),
        MyContacts("member11","사람이름11","1234@gmail.com",R.drawable.person),
        MyContacts("member12","사람이름12","1234@gmail.com",R.drawable.person)
    )

    val myJoinedgroup = mutableListOf(
        MyJoinedGroup("모임이름1",R.drawable.bokguk),
        MyJoinedGroup("모임이름2",R.drawable.bokguk),
        MyJoinedGroup("모임이름3",R.drawable.bokguk),
        MyJoinedGroup("모임이름4",R.drawable.bokguk),
        MyJoinedGroup("모임이름5",R.drawable.bokguk),
        MyJoinedGroup("모임이름6",R.drawable.bokguk),
        MyJoinedGroup("모임이름7",R.drawable.bokguk),
        MyJoinedGroup("모임이름8",R.drawable.bokguk),
        MyJoinedGroup("모임이름9",R.drawable.bokguk),
        MyJoinedGroup("모임이름10",R.drawable.bokguk),
        MyJoinedGroup("모임이름11",R.drawable.bokguk),
        MyJoinedGroup("모임이름12",R.drawable.bokguk),
        MyJoinedGroup("모임이름13",R.drawable.bokguk)
    )

    val group = mutableListOf(
        Group("group1",R.drawable.person,"초록꽃청년단1","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group2",R.drawable.person,"초록꽃청년단2","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group3",R.drawable.person,"초록꽃청년단3","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group4",R.drawable.person,"초록꽃청년단4","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group5",R.drawable.person,"초록꽃청년단5","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group6",R.drawable.person,"초록꽃청년단6","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group7",R.drawable.person,"초록꽃청년단7","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group8",R.drawable.person,"초록꽃청년단8","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group9",R.drawable.person,"초록꽃청년단9","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6")),
        Group("group10",R.drawable.person,"초록꽃청년단10","아름다운 청년들의 모임", mutableListOf("1","2","3","4","5","6"),mutableListOf("1","2","3","4","5","6"))
    )

    val member = mutableListOf(
        Member("member1",R.drawable.person,"사람이름1","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member2",R.drawable.person,"사람이름2","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member3",R.drawable.person,"사람이름3","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member4",R.drawable.person,"사람이름4","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member5",R.drawable.person,"사람이름5","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member6",R.drawable.person,"사람이름6","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member7",R.drawable.person,"사람이름7","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member8",R.drawable.person,"사람이름8","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member9",R.drawable.person,"사람이름9","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member10",R.drawable.person,"사람이름10","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member11",R.drawable.person,"사람이름11","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
        Member("member12",R.drawable.person,"사람이름12","1234@mail.com",51,"환경보호가","010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7")),
    )




}