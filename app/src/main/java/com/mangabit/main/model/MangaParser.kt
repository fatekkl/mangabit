package com.mangabit.main.model

import com.google.gson.JsonObject


data class MangaParser(
    val mal_id: Int,
    val url: String,
    val images: JsonObject,
    val name: String,
    val name_kanji: String,
    val nicknames: List<String>,
    val favorites: Int,
    val about: String,
){


}