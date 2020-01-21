package com.sehatqtestengineer.api

import com.sehatqtestengineer.model.Home
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    @GET("/home")
    fun getHomeData(): Observable<List<Home>>

}