package com.solid.twoactivityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.solid.twoactivityapp.adapter.PersonItemsAdapter
import com.solid.twoactivityapp.databinding.ActivityThirdBinding
import com.solid.twoactivityapp.model.Person

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding
    private lateinit var adapter : PersonItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListItems()
    }


    private fun setListItems(){
        val personList = arrayListOf(
            Person(name = "John Doe", sex = "Male", age = 23, image = 1),
            Person(name = "Sarah Doe", sex = "Female", age = 27, image = 2),
            Person(name = "Max Duran", sex = "Male", age = 45, image = 3),
            Person(name = "Elisha Adeboye", sex = "Male", age = 28, image = 4),
            Person(name = "Richard Don", sex = "Male", age = 26, image = 5)
        )

        adapter = PersonItemsAdapter(personList)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
    }
}