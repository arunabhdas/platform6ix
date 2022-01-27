package com.platform6ix.platform6ix.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        // TODO-FIXME-DEBUG-UI setSupportActionBar(toolbar)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        // Pass each menuId as a set of Ids because each menu
        // should be considered as a top level destination

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.currentFragment,
                R.id.homeFragment,
                R.id.dashboardFragment,
                R.id.notificationsFragment,
                R.id.futureListFragment
            )
        )
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
       return NavigationUI.navigateUp(navController, null)
    }
}