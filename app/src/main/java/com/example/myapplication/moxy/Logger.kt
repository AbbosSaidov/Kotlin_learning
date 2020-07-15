package com.example.myapplication.moxy

import android.util.Log

class Logger {

    fun printErrorLog(message: String){
        Log.i(MOXY_TAG, message)
    }

    fun printLog(message: String){
        Log.i(MOXY_TAG, message)
    }

    companion object {
        const val MOXY_TAG = "MoxyDebug"
    }
}