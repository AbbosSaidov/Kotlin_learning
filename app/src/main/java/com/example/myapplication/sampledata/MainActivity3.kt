package com.example.myapplication.sampledata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jsonPlaceHolderApi: JsonPlaceHolderApi =retrofit.create(
            JsonPlaceHolderApi::class.java)

        val call:Call<List<Post>> =jsonPlaceHolderApi.getPosts()
        call.enqueue(object:Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable){
            }
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>){
                if(!response.isSuccessful){
                    return
                }
                val okay: List<Post> = response.body()!!

                Log.i("qwerty","okay="+ okay[0].title)
            }
        })

    }
}