package com.mangabit.main.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mangabit.R
import com.mangabit.main.model.MangaParser

class MangaAdapter(private val mangas: List<MangaParser>) :
    RecyclerView.Adapter<MangaAdapter.MangaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.manga_layout, parent, false)

        return MangaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        println(mangas[position])
        holder.bind(mangas[position])
    }

    override fun getItemCount(): Int {
        return mangas.size
    }



    class MangaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: MangaParser) {
            with(itemView) {
                val manga_title = findViewById<TextView>(R.id.manga_title)
                val manga_desc = findViewById<TextView>(R.id.manga_desc)
                val manga_img = findViewById<ImageView>(R.id.manga_img)

                val imageUrl = data.getImage()

                manga_title.text = data.title
                manga_desc.text =  data.type

                if(!imageUrl.isNullOrEmpty()) {
                    Glide.with(context)
                        .load(imageUrl)
                        .into(manga_img)
                } else {
                    Toast.makeText(context , "Failed to load image", Toast.LENGTH_SHORT).show()
                }


            }
        }

    }
}