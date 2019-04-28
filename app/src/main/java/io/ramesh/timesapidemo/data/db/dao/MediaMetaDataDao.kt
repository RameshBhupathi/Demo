package io.ramesh.timesapidemo.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.ramesh.timesapidemo.data.api.model.MediaMetaData


/**
 * Created by Ramesh Bhupathi on 2019-04-28.
 */

@Dao
interface MediaMetaDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMediaMetaData(list: List<MediaMetaData>)

    @Query("SELECT * FROM MediaMetaData WHERE media_id=:mediaId")

    fun getMediaMetaDataForMedia(mediaId: Int): List<MediaMetaData>
}