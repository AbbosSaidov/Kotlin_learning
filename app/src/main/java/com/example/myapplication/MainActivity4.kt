package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.reflect.Type
import java.util.*

class MainActivity4 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //LAMBDA
        val x1={q:String->"$q+x1"}
        val x2=x1("x2")
        //Log.i("qwerty","Lambda=$x2")


        //Data class
        val x3=Person4("Name2",34)
        x3.age=23
        //Log.i("qwerty","dataClass=$x3")


        //Object
        val x4=object {
            val l1:Int=32
            val l2:Int=33
        }
       // Log.i("qwerty","object=${x4.l1}")


        //mutableListOf
        val q1= mutableListOf("qwer","asdf","ttret","cvbn")
        q1[0]="cvb"
        q1.removeAt(2)
        q1.add("bvc")
       // Log.i("qwerty","mutableListOf=$q1")


        //ListOf
        val q2 = listOf("asdf","qwre","zxcv","mbnv")
       // Log.i("qwerty","ListOf=$q2")


        //array
        val q3= arrayOf(12,21,12)
        q3[1]=2
       // Log.i("qwerty","array=${q3[1]}")

        //2d array
        val w1= arrayOf(12,32,34)
        val w2= arrayOf(12,32,34)
        val doubleArr= arrayOf(w1,w2)
       // Log.i("qwerty","2dArray=${doubleArr[0][1]}")

        //let
        Person4("Name3",31).let{
          //  Log.i("qwerty","let=$it")
            it.age=41
         //   Log.i("qwerty","let2=$it")
        }

        //apply
        val adam = Person4("Adam").apply{age = 20}

        adam.let{Log.i("qwerty",it.age.toString())}

        //with
        with(adam){age = 2; Log.i("qwerty",age.toString())}

        //progression
        /*for(i in 10 downTo 1 step 2){
             Log.i("qwerty","1=$i")
        }

        for(i in 0 until numbers.size){
             Log.i("qwerty", "2="+numbers[i])
        }*/

        //Optional
            var b : String?="asd"
            b = null
            var b2=b

            //Optional N1
            val t:Person4?=null

            if(t!=null){perform(t)}

            t?.let{perform(t)}

            var gh =if(t!=null)
            {
                t.name.length
            }else{
                32
            }

            var gk = t?.name?.length?:32

        //Singleton
        //Singleton1.printVarName()
        Log.i("qwerty","Singleton="+Singleton.getCoin())
        Singleton.addCoin(12)
        Log.i("qwerty","Singleton="+Singleton.getCoin())
        Singleton.deductCoin(3)
        Log.i("qwerty","Singleton="+Singleton.getCoin())
}
    private fun perform(person: Person4){
        Log.i("qwerty","perform called")
    }
}
data class Person4(var name: String, var age:Int=0)

open class A{
    open fun printVarName(){
        Log.i("qwerty","I am in class printVarName")
    }

    init{
        Log.i("qwerty","I am in init of A")
    }
}

object Singleton1 : A(){
    var variableName = "I am Var"
    override fun printVarName(){
        Log.i("qwerty",variableName)
    }
    init{
        Log.i("qwerty","Singleton class invoked.")
    }
}

object Singleton{
    private var coin: Int = 0

    fun getCoin():Int{
        return coin
    }

    fun addCoin(x:Int){
        coin += x
    }

    fun deductCoin(x:Int){
        coin -= x
    }
}