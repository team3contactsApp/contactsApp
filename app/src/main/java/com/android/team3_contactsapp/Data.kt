package com.android.team3_contactsapp

object Data {

    val myJoinedgroup = mutableListOf(
        MyJoinedGroup("북극 살리기 운동",R.drawable.bokguk),
        MyJoinedGroup("동물 보호 협회",R.drawable.animal),
        MyJoinedGroup("공장 매연 금지",R.drawable.carbonioxide),
        MyJoinedGroup("자동차 매연 금지",R.drawable.carexhaust),
        MyJoinedGroup("바다 생물 지키기",R.drawable.marinelife)
    )

    val group = mutableListOf(
        Group("group1",R.drawable.bokguk,"북극 지키기 운동","아름다운 북극의 얼음을 지키기 위해 만든 모임", mutableListOf("member1","member3","member4","member8","member9","member10")),
        Group("group2",R.drawable.animal,"동물 보호 협회","동물들이 떨어진 쓰레기를 먹지 않게 하기 위한 모임", mutableListOf("member1","member4","member5","member7","member9","member12")),
        Group("group3",R.drawable.carbonioxide,"공장 매연 금지","공장에서 만든 매연을 줄이기 위한 모임", mutableListOf("member2","member3","member5","member7","member8","member6")),
        Group("group4",R.drawable.carexhaust,"자동차 매연 금지","자연을 위해 대중교통을 타게 하기 위한 모임", mutableListOf("member3","member4","member7","member8","member9","member11")),
        Group("group5",R.drawable.marinelife,"바다 생물 지키기","바다에 있는 쓰레기를 청소하는 모임", mutableListOf("member2","member3","member4","member7","member9","member11"))
    )

    val member = mutableListOf(
        Member("member1",R.drawable.person,"아이유","1234@mail.com","환경보호가",51,"010-1234-1234",
            mutableListOf("group1","group5"), mutableListOf("member2","member3","member4","member7","member8","member10"),mutableListOf("member2")),
        Member("member2",R.drawable.person1,"천우희","1234@mail.com","환경보호가",51,"010-1111-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()
        ),
        Member("member3",R.drawable.person2,"은하","1234@mail.com","환경보호가",51,"010-2222-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member4",R.drawable.person3,"미연","1234@mail.com","환경보호가",51,"010-3333-1234",
            mutableListOf("group1","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"), mutableListOf()
        ),
        Member("member5",R.drawable.person4,"민니","1234@mail.com","환경보호가",51,"010-9999-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member6",R.drawable.person5,"고윤정","1234@mail.com","환경보호가",51,"010-8888-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member7",R.drawable.person6,"은채","1234@mail.com","환경보호가",51,"010-7777-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member8",R.drawable.person7,"유라","1234@mail.com","환경보호가",51,"010-6666-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member9",R.drawable.person8,"카리나","1234@mail.com","환경보호가",51,"010-5555-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member10",R.drawable.person9,"수지","1234@mail.com","환경보호가",51,"010-9090-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member11",R.drawable.person10,"장원영","1234@mail.com","환경보호가",51,"010-5151-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
        Member("member12",R.drawable.person11,"윈터","1234@mail.com","환경보호가",51,"010-9898-1234",
            mutableListOf("group1","group2","group3","group4","group5"), mutableListOf("member2","member3","member4","member6","member7"),
            mutableListOf()),
    )

}