package io.ramesh.timesapidemo.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.ramesh.timesapidemo.data.api.model.Article


/**
 * Created by Ramesh Bhupathi on 2019-04-27.
 */
@Dao
interface ArticlesDao {
    @Query("SELECT * FROM Article")
    fun getAllArticles(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<Article>)

    @Query("DELETE FROM Article")
    fun clearArticles()
}