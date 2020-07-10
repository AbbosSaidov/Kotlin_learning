package com.example.myapplication


import android.content.Intent
import androidx.appcompat.widget.Toolbar
import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.sampledata.MainActivity3


class MainActivity : AppCompatActivity(),MainActivityPresenter.View1{
     private var presenter:MainActivityPresenter?=null
     private var myTextView: TextView?=null
     private var progressBar :ProgressBar?=null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, MainActivity4::class.java)
        startActivity(intent)

      /*  val request = ServiceBuilder.buildService(TmdbEndpoints::class.java)
        val call = request.getMovies(getString(R.string.api_key))

        call.enqueue(object : Callback<PopularMovies>{
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>){
                if(response.isSuccessful){
                 Toast.makeText(this@MainActivity,"Asd" , Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable){
                  Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })*/

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        presenter = MainActivityPresenter()

        myTextView = findViewById(R.id.myTextView)
        val userName: EditText = findViewById(R.id.username)
        val email: EditText = findViewById(R.id.email)
        initProgressBar()
        userName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ){}
            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ){
                presenter!!.updateFullName(s.toString())
            }
            override fun afterTextChanged(s: Editable){
                hideProgressBar()
            }
        })

        email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ){}
            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ){
                presenter!!.updateEmail(s.toString())
            }
            override fun afterTextChanged(s: Editable){
                hideProgressBar()
            }
        })
    }
    private fun initProgressBar(){
        progressBar = ProgressBar(this, null, R.id.progress_circular)
        progressBar!!.isIndeterminate = true
        val params = RelativeLayout.LayoutParams(
            Resources.getSystem().getDisplayMetrics().widthPixels,
            250
        )
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        addContentView(progressBar, params)
        showProgressBar()
    }
     override fun updateUserInfoTextView(info: String){
         Log.i("asdf","updateUserInfoTextView")
         myTextView?.setText("info")
     }

     override fun showProgressBar(){
         progressBar?.setVisibility(View.VISIBLE)
     }

     override fun hideProgressBar(){
         progressBar?.setVisibility(View.GONE)
     }

 }
