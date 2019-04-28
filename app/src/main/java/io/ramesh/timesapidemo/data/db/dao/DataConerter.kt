package io.ramesh.timesapidemo.data.db.dao

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ramesh.timesapidemo.data.api.model.Media


/**
 * Created by Ramesh Bhupathi on 2019-04-28.
 */
class DataConerter {
    @TypeConverter
    fun fromCountryLangList(countryLang: List<Media>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {

        }.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): List<Media>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Media>>() {

        }.type
        return gson.fromJson<List<Media>>(countryLangString, type)
    }
}