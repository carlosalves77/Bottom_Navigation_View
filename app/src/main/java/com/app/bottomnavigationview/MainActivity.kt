package com.app.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.app.bottomnavigationview.fragments.DashboardFragment
import com.app.bottomnavigationview.fragments.ExploreFragment
import com.app.bottomnavigationview.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Carregar o primeiro fragmento padrão
        loadFragment(ExploreFragment())

        //Entrar em cada fragmento
        bottomNV.setOnNavigationItemSelectedListener { menuItem: MenuItem
        -> when { menuItem.itemId == R.id.navigationExplore -> {
            loadFragment(ExploreFragment())
                   return@setOnNavigationItemSelectedListener true
                 }
                menuItem.itemId == R.id.navigationDashboard -> {
                    loadFragment(DashboardFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.navigationProfile -> {
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            else -> {
                return@setOnNavigationItemSelectedListener false
                }
            }
         }
    }

    //Função para carregar os fragmentos
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().also {
            fragmentTransaction -> fragmentTransaction.replace(
            R.id.fragmentContainer, fragment)
            fragmentTransaction.commit()
        }
    }
}