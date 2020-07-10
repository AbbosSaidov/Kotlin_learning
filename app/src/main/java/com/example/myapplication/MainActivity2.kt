package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//array
        /*  val arr= arrayOf("asd",3,32,"asd",3)
            for(i in 0..(arr.size-1)){
            Log.i("asdf",i.toString()+"-"+arr[i].toString())
            }*/
//List
        val arrList = listOf(Person(1,"name1"), Person(2,"name2"),Person(3,"name3"))

        Log.i("asdf",arrList[0].id.toString())
        val ss=arrList.map { it.id }
        Log.i("asdf",ss[0].toString())
    }
}

class Person(var id:Int, val name:String)
