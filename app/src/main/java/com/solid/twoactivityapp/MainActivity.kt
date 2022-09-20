package com.solid.twoactivityapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.solid.twoactivityapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //use view-binding to bind views to the screen
    private lateinit var binding : ActivityMainBinding

    companion object{
        const val SENT_MESSAGE = "SENT_MESSAGE"
        const val REPLY_MESSAGE = "REPLY_MESSAGE"
        const val LOG_TAG = "MainActivity"
        const val LOG_TAG_SECOND = "SecondActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //click listener when send button is clicked
        binding.sendBtn.setOnClickListener {
            sendMessage()
        }

        val replyFromIntent = intent.getStringExtra(REPLY_MESSAGE)
        binding.replyMessage.text = replyFromIntent

        Log.d(LOG_TAG, "onCreate")
    }

    private fun sendMessage() {
        val intent = Intent(this, SecondActivity::class.java)
        val text = binding.editTextMain.text.trim().toString()
        if(text.isNotEmpty()){
            intent.putExtra(SENT_MESSAGE, text)
        }
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }
}