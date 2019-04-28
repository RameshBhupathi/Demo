package io.ramesh.timesapidemo.data.api.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import io.ramesh.timesapidemo.data.db.dao.DataConerter


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
@Entity(tableName = "articles")
class Article(
    @PrimaryKey var id: Long, var title: String, var byline: String,
    var published_date: String, var url: String, var adx_keywords: String,
    @TypeConverters(DataConerter::class)
    var media: List<Media>
) {
    constructor() : this(0, "", "", "", "", "", emptyList())
}