package com.example.myapplication.moxy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.moxy.ktx.KtxActivity
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity5 : MvpAppCompatActivity(R.layout.activity_main), MainView{

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private val logger = Logger()

    @ProvidePresenter
    fun providePresenter(): MainPresenter = MainPresenter(logger)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        Log.i("MoxyDebug","qweqwrwqr")
        presenter.printLog()

        findViewById<Button>(R.id.activity_main_button_ktx).setOnClickListener{
            presenter.onOpenKtxButtonClick()
        }
    }
    override fun printLog(msg: String){
        Log.i("MoxyDebug","qweqwrwqr")
        logger.printLog("printLog : msg : $msg activity hash code : ${hashCode()}")
    }

    override fun openKtxActivity(){
        startActivity(Intent(this, KtxActivity::class.java))
    }

}