package io.ramesh.timesapidemo


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */

class AppConstansts {

    companion object {
        const val BASE_URL = "https://api.nytimes.com/"
        const val CONNECT_TIMEOUT: Long = 30000
        const val READ_TIMEOUT: Long = 30000
        const val WRITE_TIMEOUT: Long = 30000
        const val API_KEY = "07G0hgyLw8uBdLpoJGG1DimAzlYhvSsu"


        const val ARTICLE_DETAILS_URL="article_url"
        const val ARTICLE_ADX_KEYWORD="adx_keyword"

        const val DATABASE_NAME="articles.db"
    }
}