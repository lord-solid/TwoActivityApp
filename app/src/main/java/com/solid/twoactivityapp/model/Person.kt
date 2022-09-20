package com.solid.twoactivityapp.model

data class Person(
    val name : String,
    val sex: String,
    val age : Int,
    val image: Int,
    val position: Int? = null
)