package io.ramesh.timesapidemo.data.db.dao

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
    @Query("SELECT * FROM articles")
    fun getAllArticles(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<Article>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(articles: Article)


    @Query("DELETE FROM articles")
    fun clearArticles()


}