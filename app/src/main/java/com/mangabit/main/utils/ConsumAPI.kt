package com.mangabit.main.utils

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.mangabit.main.model.MangaParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


private fun getData(): String? {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://api.jikan.moe/v4/top/manga")
        .build()

    return  try {
        client.newCall(request).execute().use { response ->
            if(!response.isSuccessful) {
                throw Exception("Error: $response")
            }
            response.body?.string()
        }
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}


private fun parseJson(jsonString: String?): List<MangaParser> {
    val gson = Gson()

    val jsonObject = JsonParser.parseString(jsonString).asJsonObject

    val data = jsonObject.getAsJsonArray("data")

    return gson.fromJson(data, Array<MangaParser>::class.java).toList()
}


suspend fun getManga(): List<MangaParser>  = withContext(Dispatchers.Default){
    parseJson(getData())
}

