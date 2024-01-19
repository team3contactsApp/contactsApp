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
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(),FragmentDataListener, GroupFragmentDataListener {

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

    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.framelayout, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
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

