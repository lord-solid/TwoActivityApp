package com.solid.twoactivityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solid.twoactivityapp.R
import com.solid.twoactivityapp.databinding.ActivityFourthBinding
import com.solid.twoactivityapp.databinding.ActivityMainBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            addToBackStack(null)
            commit()
        }

        binding.button1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        binding.button2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}