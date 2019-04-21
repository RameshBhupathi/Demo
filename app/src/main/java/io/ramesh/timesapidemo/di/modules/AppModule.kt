package io.ramesh.timesapidemo.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import io.ramesh.timesapidemo.MyApplication
import io.vrinda.medigin.di.modules.ViewModelModule
import javax.inject.Singleton


/**
 * Created by Ramesh Bhupathi on 14/03/19.
 */

@Module(includes = [ViewModelModule::class])
abstract class AppModule {
    @Binds
    @Singleton
    internal abstract fun bindContext(application: MyApplication): Context

}