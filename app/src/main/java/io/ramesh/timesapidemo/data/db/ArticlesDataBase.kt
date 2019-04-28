package io.ramesh.timesapidemo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.ramesh.timesapidemo.data.api.model.Article
import io.ramesh.timesapidemo.data.api.model.Media
import io.ramesh.timesapidemo.data.api.model.MediaMetaData
import io.ramesh.timesapidemo.data.db.dao.ArticlesDao
import io.ramesh.timesapidemo.data.db.dao.DataConerter
import io.ramesh.timesapidemo.data.db.dao.MediaDao
import io.ramesh.timesapidemo.data.db.dao.MediaMetaDataDao


/**
 * Created by Ramesh Bhupathi on 2019-04-27.
 */

@Database(entities = arrayOf(Article::class, Media::class, MediaMetaData::class), version = 1)
@TypeConverters(DataConerter::class)
abstract class ArticlesDataBase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao

    abstract fun mediaDao(): MediaDao

    abstract fun mediaMetaDataDao(): MediaMetaDataDao

    private var instance: ArticlesDataBase? = null

    fun getInstance(context: Context): ArticlesDataBase? {
        if (instance == null) {
            synchronized(ArticlesDataBase::class) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticlesDataBase::class.java, "articles"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
        return instance
    }

}