package io.ramesh.timesapidemo.api.model


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
data class Article(
    var id: Long, var title: String, var byline: String,
    var published_date: String, var url: String,var adx_keywords :String

) {

}