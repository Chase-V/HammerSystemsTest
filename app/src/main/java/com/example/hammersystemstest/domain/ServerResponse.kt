package com.example.hammersystemstest.domain

import com.google.gson.annotations.SerializedName

data class ServerResponse(
    @SerializedName("title")
    val title:String,
    @SerializedName("explanation")
    val explanation:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("media_type")
    val mediaType:String
)
