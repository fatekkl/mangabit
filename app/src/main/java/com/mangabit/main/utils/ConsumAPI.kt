package com.mangabit.main.utils

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.mangabit.main.model.MangaParser
import okhttp3.OkHttpClient
import okhttp3.Request


private fun getData():String?{
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://api.jikan.moe/v4/top/manga")
        .build()


    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            throw Exception("Error: $response")
        }

        return response.body?.string()
    }
}



private fun parseJson (jsonString: String?): List<MangaParser> {
    val gson = Gson()

    val jsonObject = JsonParser.parseString(jsonString).asJsonObject

    val data = jsonObject.getAsJsonArray("data")

    return gson.fromJson(data , Array<MangaParser>::class.java).toList()
}


fun getManga(): List<MangaParser> {
    return parseJson(getData())
}


