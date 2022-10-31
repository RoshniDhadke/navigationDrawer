package com.example.relativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawer:DrawerLayout
    lateinit var actionBar:ActionBarDrawerToggle
    lateinit var navView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer=findViewById(R.id.drawer)
        actionBar=ActionBarDrawerToggle(this,drawer,R.string.nav_open,R.string.nav_close)
        drawer.addDrawerListener(actionBar)
        actionBar.syncState()

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
         navView=findViewById(R.id.navView)
         navView.setNavigationItemSelectedListener {
             when(it.itemId){
                 R.id.nav_account->Toast.makeText(applicationContext,"clicked on Account",Toast.LENGTH_SHORT).show()
                 R.id.nav_setting->Toast.makeText(applicationContext,"clicked on Setting",Toast.LENGTH_SHORT).show()
                 R.id.nav_logout->Toast.makeText(applicationContext,"clicked on Logout",Toast.LENGTH_SHORT).show()
             }
             true
         }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBar.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}