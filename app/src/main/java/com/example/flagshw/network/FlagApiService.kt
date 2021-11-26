package com.example.flagshw.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


// URL for photo\data
private const val BASE_URL = "https://countriesnow.space"

    private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

 // create a Retrofit object.
     private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()






// defines how Retrofit talks to the web server using HTTP requests.
    interface FlagApiService {
    @GET("/api/v0.1/countries/flag/images")
   suspend fun getPhotos() : FlagPhoto

}

// to initialize the Retrofit service.
    // This is the public singleton object that can be accessed from the rest of the app.

    object FlagApi {
      val retrofitService: FlagApiService by lazy {
          retrofit.create(FlagApiService::class.java)
      }


    }









