package com.tta.china_myandictionary

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tta.china_myandictionary.ui.dashboard.DashboardFragment
import com.tta.china_myandictionary.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        loadfragment(DashboardFragment())

       // val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //val navController = findNavController(R.id.nav_host_fragment)
//        Passing each menu ID as a set of Ids because each
//         menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
    //    navView.setupWithNavController(navController)
//        link.setOnClickListener {
//            val intent = Intent(this,DashboardFragment::class.java);
//            startActivity(intent)

        // }
        nav_view.setOnNavigationItemSelectedListener {menuItem->
            when{
                menuItem.itemId == R.id.navigation_dashboard -> {
                    loadfragment(DashboardFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.navigation_home ->{
                    loadfragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }

        }
    }

    private  fun loadfragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.nav_host_fragment,fragment)
            fragmentTransaction.commit()

        }
    }
}