package com.example.myapplication.moxy.ktx

import com.example.myapplication.moxy.Logger
import moxy.MvpPresenter

class KtxPresenter constructor(
    private val logger: Logger
) : MvpPresenter<KtxView>(){

    override fun onFirstViewAttach(){
        super.onFirstViewAttach()

        logger.printLog("presenter hash code : ${hashCode()}")
        viewState.printKtxLog("TEST")
    }

    fun printLog(){
        viewState.printKtxLog("TEST ktx print log ${hashCode()}")
    }
}