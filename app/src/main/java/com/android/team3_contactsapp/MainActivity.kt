package com.android.team3_contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.team3_contactsapp.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.tabs.TabLayout
class MainActivity : AppCompatActivity() {

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

        val adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    0 -> setFragment(MyContactsFragment())
                    1 -> setFragment(GroupFragment())
                    2 -> setFragment(ContactDetailFragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        setFragment(MyContactsFragment())
    }


    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frame_layout, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}