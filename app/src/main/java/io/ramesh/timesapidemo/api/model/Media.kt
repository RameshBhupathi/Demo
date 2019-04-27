package io.ramesh.timesapidemo.api.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Ramesh Bhupathi on 2019-04-25.
 */
data class Media(
    var type: String, var subtype: String, var caption: String,
    var copyright: String,
    @SerializedName("media-metadata") var mediaMetadata: List<MediaMetaData>,
    @SerializedName("approved_for_syndication") val approvedForSyndication: Int
) {

}