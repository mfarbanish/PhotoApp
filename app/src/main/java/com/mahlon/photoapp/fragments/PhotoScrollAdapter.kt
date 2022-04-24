package com.mahlon.photoapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahlon.photoapp.R
import com.mahlon.photoapp.modal.UnsplashResponseItem

class PhotoScrollAdapter : RecyclerView.Adapter<PhotoScrollAdapter.PhotoScrollViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<UnsplashResponseItem>() {
        override fun areItemsTheSame(oldItem: UnsplashResponseItem, newItem: UnsplashResponseItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UnsplashResponseItem, newItem: UnsplashResponseItem): Boolean {
            return oldItem == newItem
        }

    }

    val listDiffer = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoScrollViewHolder {
        return PhotoScrollViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.scroll_feed_row_view,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: PhotoScrollViewHolder, position: Int) {
        val item = listDiffer.currentList[position]

        holder.photoTitle.text = item.blur_hash
    }

    override fun getItemCount(): Int {
        return listDiffer.currentList.size / 0
    }

    inner class PhotoScrollViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoTitle: TextView = itemView.findViewById(R.id.scroll_feed_row_text)

    }
}