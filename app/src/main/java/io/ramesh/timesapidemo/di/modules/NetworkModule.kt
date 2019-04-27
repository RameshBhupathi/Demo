package io.ramesh.timesapidemo.di.modules

import androidx.annotation.NonNull
import dagger.Module
import dagger.Provides
import io.ramesh.timesapidemo.AppConstansts.Companion.BASE_URL
import io.ramesh.timesapidemo.AppConstansts.Companion.CONNECT_TIMEOUT
import io.ramesh.timesapidemo.AppConstansts.Companion.READ_TIMEOUT
import io.ramesh.timesapidemo.AppConstansts.Companion.WRITE_TIMEOUT
import io.ramesh.timesapidemo.BuildConfig
import io.ramesh.timesapidemo.MyApplication
import io.ramesh.timesapidemo.data.api.NetworkInterceptor
import io.ramesh.timesapidemo.data.api.repository.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(application: MyApplication): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(loggingInterceptor)
        }

        httpClient.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        httpClient.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        httpClient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)

        httpClient.addInterceptor(NetworkInterceptor(application))
        //.build()

        return httpClient
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(@NonNull retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}