package com.example.myapplication.moxy

import moxy.MvpPresenter

class MainPresenter constructor(
    private val logger: Logger
) : MvpPresenter<MainView>(){

    override fun onFirstViewAttach(){
        super.onFirstViewAttach()

        logger.printLog( "presenter hash code : ${hashCode()}")
        viewState.printLog("TEST")
    }

    fun printLog(){
        viewState.printLog("TEST print log ${hashCode()}")
    }

    fun onOpenKtxButtonClick(){
        viewState.openKtxActivity()
    }

}