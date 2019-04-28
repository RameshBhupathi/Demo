package io.ramesh.timesapidemo.di.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.ramesh.timesapidemo.AppConstansts
import io.ramesh.timesapidemo.MyApplication
import io.ramesh.timesapidemo.data.db.ArticlesDataBase
import io.ramesh.timesapidemo.data.db.dao.ArticlesDao
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton


/**
 * Created by Ramesh Bhupathi on 2019-04-27.
 */
@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideArticlesDataBase(application: MyApplication): ArticlesDataBase {

        return Room.databaseBuilder(
            application, ArticlesDataBase::class.java,
            AppConstansts.DATABASE_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor();

    }

    @Provides
    @Singleton
    fun providesArticlesDao(articlesDataBase: ArticlesDataBase): ArticlesDao {
        return articlesDataBase.articlesDao()
    }

    /* @Provides
     @Singleton
     fun providesMediaListsDao(articlesDataBase: ArticlesDataBase): MediaDao {
         return articlesDataBase.mediaDao()
     }

     @Provides
     @Singleton
     fun providesMediaMetaData(articlesDataBase: ArticlesDataBase): MediaMetaDataDao {
         return articlesDataBase.mediaMetaDataDao()
     }*/
}


