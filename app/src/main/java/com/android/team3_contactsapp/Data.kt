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
        MyJoinedGroup("모임이름1",R.drawable.bokguk, "group1"),
        MyJoinedGroup("모임이름2",R.drawable.bokguk, "group2"),
//        MyJoinedGroup("모임이름3",R.drawable.bokguk, "group3"),
//        MyJoinedGroup("모임이름4",R.drawable.bokguk, "group4"),
//        MyJoinedGroup("모임이름5",R.drawable.bokguk, "group5"),
//        MyJoinedGroup("모임이름6",R.drawable.bokguk, "group6"),
//        MyJoinedGroup("모임이름7",R.drawable.bokguk, "group7"),
//        MyJoinedGroup("모임이름8",R.drawable.bokguk, "group8"),
//        MyJoinedGroup("모임이름9",R.drawable.bokguk, "group9"),
//        MyJoinedGroup("모임이름10",R.drawable.bokguk, "group10"),
//        MyJoinedGroup("모임이름11",R.drawable.bokguk, "group11"),
//        MyJoinedGroup("모임이름12",R.drawable.bokguk, "group12"),
//        MyJoinedGroup("모임이름13",R.drawable.bokguk, "group13")
    )

    val group = mutableListOf(
        Group("group1",R.drawable.person,"초록꽃청년단1","아름다운 청년들의 모임", mutableListOf("member1","member3","member4","member8","member9","member10")),
        Group("group2",R.drawable.person,"초록꽃청년단2","아름다운 청년들의 모임", mutableListOf("member1","member4","member5","member7","member9","member12")),
        Group("group3",R.drawable.person,"초록꽃청년단3","아름다운 청년들의 모임", mutableListOf("member2","member3","member5","member7","member8","member6")),
        Group("group4",R.drawable.person,"초록꽃청년단4","아름다운 청년들의 모임", mutableListOf("member3","member4","member7","member8","member9","member11")),
        Group("group5",R.drawable.person,"초록꽃청년단5","아름다운 청년들의 모임", mutableListOf("member2","member3","member4","member7","member9","member11")),
        Group("group6",R.drawable.person,"초록꽃청년단6","아름다운 청년들의 모임", mutableListOf("member8","member9","member10","member11")),
        Group("group7",R.drawable.person,"초록꽃청년단7","아름다운 청년들의 모임", mutableListOf("member6","member7","member8","member9","member10","member12")),
        Group("group8",R.drawable.person,"초록꽃청년단8","아름다운 청년들의 모임", mutableListOf("member3","member4","member6","member8","member9","member11")),
        Group("group9",R.drawable.person,"초록꽃청년단9","아름다운 청년들의 모임", mutableListOf("member2","member5","member9","member10","member11","member12")),
        Group("group10",R.drawable.person,"초록꽃청년단10","아름다운 청년들의 모임", mutableListOf("member1","member2","member3","member4","member5","member6"))
    )

    val member = mutableListOf(
        Member("member1",R.drawable.person,"사람이름1","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group3","group4","group5","group7","group8","group9","group10"), mutableListOf("member2","member3","member4","member7","member8","member10"),mutableListOf("member2")),
        Member("member2",R.drawable.person,"사람이름2","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()
        ),
        Member("member3",R.drawable.person,"사람이름3","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member4",R.drawable.person,"사람이름4","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"), mutableListOf()
        ),
        Member("member5",R.drawable.person,"사람이름5","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member6",R.drawable.person,"사람이름6","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member7",R.drawable.person,"사람이름7","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member8",R.drawable.person,"사람이름8","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member9",R.drawable.person,"사람이름9","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member10",R.drawable.person,"사람이름10","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member11",R.drawable.person,"사람이름11","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member12",R.drawable.person,"사람이름12","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
    )

    val post = mutableListOf(
        Post("post1",R.drawable.bokguk,"글제목1","글내용1","작성자1",51),
        Post("post2",R.drawable.bokguk,"글제목2","글내용2","작성자2",51),
        Post("post3",R.drawable.bokguk,"글제목3","글내용3","작성자3",51),
        Post("post4",R.drawable.bokguk,"글제목4","글내용4","작성자4",51),
        Post("post5",R.drawable.bokguk,"글제목5","글내용5","작성자5",51),
        Post("post6",R.drawable.bokguk,"글제목6","글내용6","작성자6",51),
        Post("post7",R.drawable.bokguk,"글제목7","글내용7","작성자7",51),
        Post("post8",R.drawable.bokguk,"글제목8","글내용8","작성자8",51),
        Post("post9",R.drawable.bokguk,"글제목9","글내용9","작성자9",51),
        Post("post10",R.drawable.bokguk,"글제목10","글내용10","작성자10",51),
        Post("post11",R.drawable.bokguk,"글제목11","글내용11","작성자11",51),
        Post("post12",R.drawable.bokguk,"글제목12","글내용12","작성자12",51),
        Post("post13",R.drawable.bokguk,"글제목13","글내용13","작성자13",51),
        Post("post14",R.drawable.bokguk,"글제목14","글내용14","작성자14",51),
    )


}