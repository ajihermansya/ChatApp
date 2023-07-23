package com.rumahcerita.chappappclonewa.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.firebase.auth.FirebaseAuth
import com.rumahcerita.chappappclonewa.MainActivity
import com.rumahcerita.chappappclonewa.R
import com.rumahcerita.chappappclonewa.databinding.ActivityNumberBinding

class NumberActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNumberBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Hide ActionBar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()


        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.button.setOnClickListener {
            if (binding.phoneNumber.text!!.isEmpty()) {
                Toast.makeText(this, "Please enter your Number!!", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this, OTPActivity::class.java)
                intent.putExtra("number", binding.phoneNumber.text!!.toString())
                startActivity(intent)
            }
        }

    }
}