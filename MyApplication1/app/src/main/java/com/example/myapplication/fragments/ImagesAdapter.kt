package com.example.myapplication.fragments

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.utils.ImageUtils

class ImagesAdapter(
    private val images: List<Uri>,
    private val context: Context
) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUri = images[position]

        val bitmap = ImageUtils.getScaledBitmapFromUri(
            context.contentResolver,
            imageUri,
            holder.imageView.width,
            holder.imageView.height
        )

        if (bitmap != null) {
            holder.imageView.setImageBitmap(bitmap)
        } else {
            println("Nie udało się załadować obrazu: $imageUri")
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}
