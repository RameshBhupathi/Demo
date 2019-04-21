package io.ramesh.timesapidemo.api.repository

import io.ramesh.timesapidemo.api.response.MostViewedArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */

interface ApiService {
    //https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=07G0hgyLw8uBdLpoJGG1DimAzlYhvSsu

    @GET("svc/mostpopular/v2/viewed/{index}.json")
    fun getMostViewedArticles(@Path("index") index: Int): Call<MostViewedArticlesResponse>
}