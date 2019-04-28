package io.ramesh.timesapidemo.data.api.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by Ramesh Bhupathi on 2019-04-25.
 */
@Entity
class Media constructor(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ForeignKey(
    entity = Article::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("article_id"))
    var article_id: Long,
    var type: String,
    var subtype: String,
    var caption: String,
    var copyright: String,
    @SerializedName("media-metadata")
    @Ignore var mediaMetadata: List<MediaMetaData>,
    @SerializedName("approved_for_syndication") var approvedForSyndication: Int
) {
    constructor() : this(0, 0, "", "", "", "", emptyList(), 0)
}