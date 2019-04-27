package io.ramesh.timesapidemo.data.api

import io.ramesh.timesapidemo.AppConstansts.Companion.API_KEY
import io.ramesh.timesapidemo.MyApplication
import okhttp3.Interceptor
import okhttp3.Response


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
class NetworkInterceptor(val application: MyApplication) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalHttpUrl = request.url()

        //Creating new url with api key as query parameter
        val url = originalHttpUrl.newBuilder().addQueryParameter("api-key", API_KEY).build()

        return chain.proceed(request.newBuilder().url(url).build())
    }

}