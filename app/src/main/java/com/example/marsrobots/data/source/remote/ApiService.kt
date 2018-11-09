package com.example.marsrobots.data.source.remote

import com.example.marsrobots.data.ImagesList
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/search?q=mars&media_type=image")
    fun getImages(): Single<ImagesList>
}