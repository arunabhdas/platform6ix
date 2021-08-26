package com.platform6ix.platform6ix.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.NonSdkApiUsedViolation
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.platform6ix.platform6ix.R

class DashboardActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        // Pass each menuId as a set of Ids because each menu
        // should be considered as a top level destination

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }
}