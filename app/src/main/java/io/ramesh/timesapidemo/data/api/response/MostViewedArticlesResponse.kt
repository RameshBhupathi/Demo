package io.ramesh.timesapidemo.data.api.response

import io.ramesh.timesapidemo.data.api.model.Article


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
class MostViewedArticlesResponse(var results: MutableList<Article>) : BaseResponse() {

}