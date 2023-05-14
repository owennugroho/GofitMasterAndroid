package com.example.gofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gofit.fragment.AkunFragment
import com.example.gofit.fragment.BookingFragment
import com.example.gofit.fragment.HomeFragment
import com.example.gofit.fragment.IjinFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentBooking: Fragment = BookingFragment()
    private val fragmentAkun: Fragment = AkunFragment()
    private val fragmentIjin: Fragment = IjinFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpBottomNav()
    }

    fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentBooking).hide(fragmentBooking).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()
        fm.beginTransaction().add(R.id.container, fragmentIjin).hide(fragmentIjin).commit()


        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when(item.itemId) {
                R.id.navigation_home->{
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_booking->{
                    callFragment(1, fragmentBooking)
                }
                R.id.navigation_ijin->{
                    callFragment(2, fragmentIjin)
                }
                R.id.navigation_akun->{
                    callFragment(3, fragmentAkun)
                }
            }

            false
        }
    }
    fun callFragment(int: Int, fragment: Fragment) {
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}