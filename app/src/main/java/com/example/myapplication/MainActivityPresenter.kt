package com.example.myapplication

import android.util.Log

class MainActivityPresenter{
     var user: User? = null
     var view: View1? = null
    fun updateFullName(fullName:String){
        user?.fullName=fullName
        view?.updateUserInfoTextView(user?.toString2().toString())
    }
    fun updateEmail(email:String){
        user?.email=email
        Log.i("asdf",user?.email.toString()+" = "+email)
        view?.updateUserInfoTextView("sdfdfs")
    }
     interface View1{
        fun updateUserInfoTextView(info:String)
        fun showProgressBar()
        fun hideProgressBar()
    }
}