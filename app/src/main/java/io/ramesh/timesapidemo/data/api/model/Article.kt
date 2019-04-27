package io.ramesh.timesapidemo.data.api.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
@Entity
data class Article(
    @PrimaryKey val id: Long, var title: String, var byline: String,
    var published_date: String, var url: String, var adx_keywords: String,
    var media: List<Media>
) {

}