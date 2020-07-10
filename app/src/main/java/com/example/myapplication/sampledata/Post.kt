package com.example.myapplication.sampledata

import com.google.gson.annotations.SerializedName

class Post{
    var id=0
    var userId=0
    var title:String?=null

    @SerializedName("body")
    var text:String?=null
}