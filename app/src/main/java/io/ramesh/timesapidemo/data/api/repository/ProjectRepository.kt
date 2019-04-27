package io.ramesh.timesapidemo.data.api.repository

import androidx.lifecycle.MutableLiveData
import io.ramesh.timesapidemo.data.api.Resource
import io.ramesh.timesapidemo.data.api.response.MostViewedArticlesResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
class ProjectRepository @Inject constructor(apiService: ApiService) {
    private var apiService: ApiService

    init {
        this.apiService = apiService
    }


    fun getMostViewedArticles(index: Int): MutableLiveData<Resource<*>> {
        var data = MutableLiveData<Resource<*>>()
        apiService.getMostViewedArticles(7)
            .enqueue(object : javax.security.auth.callback.Callback, retrofit2.Callback<MostViewedArticlesResponse> {
                override fun onFailure(call: Call<MostViewedArticlesResponse>, t: Throwable) {
                    data.value = Resource(false, null, t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<MostViewedArticlesResponse>,
                    response: Response<MostViewedArticlesResponse>
                ) {
                    if (response.isSuccessful) {
                        data.value = Resource(true, response.body(), "sucess")
                    } else {
                        data.value = Resource(false, response.errorBody(), response.message())
                    }
                }

            })
        return data;
    }

}