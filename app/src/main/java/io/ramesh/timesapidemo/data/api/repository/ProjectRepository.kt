package io.ramesh.timesapidemo.data.api.repository

import androidx.lifecycle.MutableLiveData
import io.ramesh.timesapidemo.data.api.Resource
import io.ramesh.timesapidemo.data.api.response.MostViewedArticlesResponse
import io.ramesh.timesapidemo.data.db.dao.ArticlesDao
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.Executors
import javax.inject.Inject


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
class ProjectRepository @Inject constructor(
    apiService: ApiService, var articlesDao: ArticlesDao
) {
    private var apiService: ApiService

    init {
        this.apiService = apiService

    }


    fun getMostViewedArticles(index: Int): MutableLiveData<Resource<*>> {
        var data = MutableLiveData<Resource<*>>()

        data.value = Resource(true, articlesDao.getAllArticles(), "sucess")

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
                        //BgTask(articlesDao, response).execute()
                        data.value = Resource(true, response.body()?.results, "sucess")
                        Executors.newSingleThreadExecutor().execute(Runnable {
                            articlesDao.insertArticles(response.body()!!.results)
                        })

                    } else {
                        data.value = Resource(false, response.errorBody(), response.message())
                    }
                }

            })

        return data;
    }
}