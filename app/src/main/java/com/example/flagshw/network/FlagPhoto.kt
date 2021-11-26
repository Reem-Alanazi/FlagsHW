package com.example.flagshw.network

import com.squareup.moshi.Json

data class FlagPhoto(val error : Boolean , val msg : String , val data : List<Photo>)

data class Photo(@Json(name="name") val name : String, @Json(name= "flag") val flagUrl:String)
