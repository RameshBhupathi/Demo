package io.ramesh.timesapidemo.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.ramesh.timesapidemo.MyApplication
import io.ramesh.timesapidemo.di.modules.ActivityModule
import io.ramesh.timesapidemo.di.modules.AppModule
import io.ramesh.timesapidemo.di.modules.NetworkModule
import io.ramesh.timesapidemo.di.modules.RoomModule
import javax.inject.Singleton


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        RoomModule::class,
        ActivityModule::class
     ]
)

internal interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MyApplication): AppComponent.Builder

        fun build(): AppComponent
    }
}



