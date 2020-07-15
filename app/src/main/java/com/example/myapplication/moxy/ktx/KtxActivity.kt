package com.example.myapplication.moxy.ktx

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.moxy.Logger
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class KtxActivity : MvpAppCompatActivity(),KtxView{

    val logger = Logger()

    val ktxPresenter by moxyPresenter{
        KtxPresenter(logger)
    }

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx)

        ktxPresenter.printLog()
    }

    override fun printKtxLog(msg: String){
        logger.printLog("printKtxLog : msg : $msg activity hash code : ${hashCode()}")
    }

}