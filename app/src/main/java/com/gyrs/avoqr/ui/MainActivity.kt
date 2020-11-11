package com.gyrs.avoqr.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gyrs.avoqr.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navControler : NavController
    private lateinit var appBarConfiguration : AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        ) as NavHostFragment

        navControler = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.cameraFragment, R.id.homeFragment)
        )

        setSupportActionBar(toolBar)
        setupActionBarWithNavController(navControler, appBarConfiguration)

        bottom_nav.setupWithNavController(navControler)

        navControler
            .addOnDestinationChangedListener{_, destination,_ ->
                when(destination.id){
                    R.id.loginFragment, -> {
                        bottom_nav.visibility = View.GONE
                        toolBar.visibility = View.GONE
                    }
                    R.id.detailsFragment, R.id.addFragment ->{
                        bottom_nav.visibility = View.GONE
                    }
                    else -> {
                        bottom_nav.visibility = View.VISIBLE
                        toolBar.visibility = View.VISIBLE

                        if (destination.id == R.id.homeFragment || destination.id == R.id.cameraFragment) {
                            //navControler.popBackStack()
                        }
                    }
                }
            }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navControler) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navControler.navigateUp() || super.onSupportNavigateUp()
    }

}