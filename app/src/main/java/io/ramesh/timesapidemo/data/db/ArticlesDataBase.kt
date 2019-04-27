package io.ramesh.timesapidemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.ramesh.timesapidemo.data.api.model.Article
import io.ramesh.timesapidemo.data.db.dao.ArticlesDao


/**
 * Created by Ramesh Bhupathi on 2019-04-27.
 */

@Database(entities = arrayOf(Article::class), version = 1)
abstract class ArticlesDataBase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao

}