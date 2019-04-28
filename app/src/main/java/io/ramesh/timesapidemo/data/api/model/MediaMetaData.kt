package io.ramesh.timesapidemo.data.api.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by Ramesh Bhupathi on 2019-04-25.
 */


@Entity
class MediaMetaData constructor(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ForeignKey(
    entity = Media::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("media_id"))
    var media_id: Int,
    @SerializedName("url") var url: String,
    @SerializedName("format") var format: String,
    @SerializedName("height") var height: Int,
    @SerializedName("width") var width: Int
) {
    constructor() : this(0, 0, "", "", 0, 0)
}