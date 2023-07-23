package com.rumahcerita.chappappclonewa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.rumahcerita.chappappclonewa.activity.NumberActivity
import com.rumahcerita.chappappclonewa.adapter.ViewPagerAdapter
import com.rumahcerita.chappappclonewa.databinding.ActivityMainBinding
import com.rumahcerita.chappappclonewa.databinding.ActivityNumberBinding
import com.rumahcerita.chappappclonewa.ui.CallFragment
import com.rumahcerita.chappappclonewa.ui.ChatFragment
import com.rumahcerita.chappappclonewa.ui.StatusFragment

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        // Hide ActionBar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val fragmentArrayList = ArrayList<Fragment>()
        fragmentArrayList.add(ChatFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallFragment())

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            startActivity(Intent(this, NumberActivity::class.java))
            finish()
        }


        val adapter = ViewPagerAdapter(this, supportFragmentManager, fragmentArrayList)
        binding!!.viewPager.adapter = adapter
        binding!!.tabs.setupWithViewPager(binding!!.viewPager)


    }
}