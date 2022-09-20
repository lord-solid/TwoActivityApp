package com.solid.twoactivityapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.solid.twoactivityapp.databinding.RecyclerviewItemBinding
import com.solid.twoactivityapp.model.Person

class PersonItemsAdapter(private val personList: ArrayList<Person>): RecyclerView.Adapter<PersonItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewItemBinding.inflate(layoutInflater)
        return PersonItemsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonItemsViewHolder, position: Int) {
        holder.bind(personList[position], position)
    }

    override fun getItemCount(): Int = personList.size
}

class PersonItemsViewHolder(private val binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(person: Person, position: Int){
        binding.nameText.text = person.name
        binding.ageText.text = person.age.toString()
        binding.sexText.text = person.sex
//        binding.imageView.setImageDrawable(person.image)
        binding.numText.text = position.toString()
    }
}