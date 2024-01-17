package com.android.team3_contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.team3_contactsapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.android.team3_contactsapp.databinding.FragmentMyContactsBinding

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(),FragmentDataListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_my_contacts)
//
//        navView.setupWithNavController(navController)

        initViewPager()

    }

    private fun initViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.addFragment(MyContactsFragment())
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
    }

    override fun onDataReceived(data: Member) {
        val intent = Intent(this,ContactDetailActivity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
        Log.d("test","여기 거처가는거냐? ${data}, ${intent}")
    }
}