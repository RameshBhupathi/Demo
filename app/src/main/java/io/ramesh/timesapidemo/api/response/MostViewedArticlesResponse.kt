package io.ramesh.timesapidemo.api.response

import io.ramesh.timesapidemo.api.model.Article


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
class MostViewedArticlesResponse(var results: MutableList<Article>) : BaseResponse() {

}