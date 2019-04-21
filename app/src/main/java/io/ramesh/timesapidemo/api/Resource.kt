package io.ramesh.timesapidemo.api


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
data class Resource<out T>(val status: Boolean, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(true , data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(false, data, msg)
        }

    }
}