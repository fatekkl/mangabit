package com.mangabit.main.model

import com.google.gson.JsonElement
import com.google.gson.JsonObject


data class MangaParser(
    val mal_id: Int,
    val url: String,
    val images: JsonObject,
//    val approved: Boolean,
//    val titles: JsonArray,
    val title: String,
//    val title_english: String,
//    val title_japanese: String,
    val type: String = "Manga",
//    val chapters: Int,
//    val volumes: Int,
//    val status: String,
//    val publishing: Boolean,
//    val published: JsonObject,
//    val score: Int,
//    val scored_by: Int,
//    val rank: Int,
//    val popularity: Int,
//    val members: Int,
//    val synopsis: String,
//    val background: String,
//    val authors: JsonArray,
//    val serializations: JsonArray,
//    val genres: JsonArray,
//    val explicit_genres: JsonArray,
//    val themes: JsonArray,
//    val demographics: JsonArray

) {

    fun getImage(): JsonElement {
        val jpgImages = images.getAsJsonObject("jpg")

        return jpgImages.get("image_url")
    }
}