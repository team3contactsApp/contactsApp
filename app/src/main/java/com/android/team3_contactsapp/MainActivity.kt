package com.android.team3_contactsapp

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import androidx.activity.OnBackPressedCallback
import com.android.team3_contactsapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(),FragmentDataListener, GroupFragmentDataListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }

    private fun initViewPager() {
        val bundle = Bundle()
        //bundle.putByte("key", Data.member)
        val myContactsFragment = MyContactsFragment.newInstance(bundle)

        val viewPagerAdapter = ViewPagerAdapter(this)

        viewPagerAdapter.addFragment(myContactsFragment)
        viewPagerAdapter.addFragment(GroupFragment())
        viewPagerAdapter.addFragment(MypageFragment())

        binding.viewpager.apply {
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }


        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            when(position) {
                0 -> {
                    tab.setText(R.string.title_home)
                    tab.setIcon(R.drawable.phonecall)
                }
                1 -> {
                    tab.setText(R.string.title_dashboard)
                    tab.setIcon(R.drawable.group)
                }
                2 -> {
                    tab.setText(R.string.title_notifications)
                    tab.setIcon(R.drawable.info)
                }
            }
        }.attach()


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    0 -> {

                    }
                    1 -> Log.i("Minyong", "tab2")
                    2 -> Log.i("Minyong", "tab3")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }


    override fun onDataReceived(data: Member) {
        val intent = Intent(this,ContactDetailActivity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
        //Log.d("test","여기 거처가는거냐? ${data}, ${intent}")
    }

    override fun onGroupFragDataReceived(data: Group) {
        val intent = Intent(this, GroupDetailActivity::class.java)
        intent.putExtra("Minyong", data)
        startActivity(intent)
    }
}

