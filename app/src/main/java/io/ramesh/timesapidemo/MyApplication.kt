package io.ramesh.timesapidemo

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.ramesh.timesapidemo.di.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */

class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build();
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(DebugTree())

    }
}