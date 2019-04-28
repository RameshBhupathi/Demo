package io.ramesh.timesapidemo.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.ramesh.timesapidemo.data.api.model.Media


/**
 * Created by Ramesh Bhupathi on 2019-04-28.
 */

@Dao
interface MediaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMedia(list: List<Media>)

    @Query("SELECT * FROM Media WHERE article_id=:articleId")
    fun getMediaForArticle(articleId: Long): List<Media>

    @Query("SELECT * FROM Media ")
    fun getAllMedia(): List<Media>

}