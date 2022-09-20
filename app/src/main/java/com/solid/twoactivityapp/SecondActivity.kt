package com.solid.twoactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.solid.twoactivityapp.MainActivity.Companion.LOG_TAG_SECOND
import com.solid.twoactivityapp.MainActivity.Companion.REPLY_MESSAGE
import com.solid.twoactivityapp.MainActivity.Companion.SENT_MESSAGE
import com.solid.twoactivityapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
//    private  var headerIsVisible: Boolean = false
//    private  var messageValue: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textMessage.text = intent.getStringExtra(SENT_MESSAGE)

        binding.replyBtn.setOnClickListener {
            reply()
        }

        if (savedInstanceState != null){
           val headerIsVisible = savedInstanceState.getBoolean("reply_visible")
            val messageValue = savedInstanceState.getString("reply_text").toString()

            Log.d(LOG_TAG_SECOND, "$headerIsVisible and $messageValue")
        }else{
            Log.d(LOG_TAG_SECOND, "these are null values here")
        }

        Log.d(LOG_TAG_SECOND, "OnCreate")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        if(binding.textHeader.visibility == View.VISIBLE){
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", binding.textMessage.text.toString())
        }
    }

    private fun reply() {
        val intent = Intent(this, MainActivity::class.java)
        val replyText = binding.editTextSecond.text.trim().toString()
        if(replyText.isNotEmpty())  intent.putExtra(REPLY_MESSAGE, replyText)

        startActivity(intent)
        Log.d(LOG_TAG_SECOND, "End SecondActivity");
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG_SECOND, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG_SECOND, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG_SECOND, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG_SECOND, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG_SECOND, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG_SECOND, "onDestroy")
    }


}