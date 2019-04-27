package io.ramesh.timesapidemo.data.api.response


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
abstract class BaseResponse(
    var status: Boolean = true,
    var message: String? = null
) {

}