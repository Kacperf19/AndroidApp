package com.example.myapplication.fragments

import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ImagesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)

        val images = getAllImages()

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = ImagesAdapter(images, requireContext())
    }

    private fun getAllImages(): List<Uri> {
        val imageList = mutableListOf<Uri>()
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.Media._ID)

        requireContext().contentResolver.query(uri, projection, null, null, null)?.use { cursor ->
            val columnIndexId = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            while (cursor.moveToNext()) {
                val imageId = cursor.getLong(columnIndexId)
                val imageUri = Uri.withAppendedPath(uri, imageId.toString())
                imageList.add(imageUri)
            }
        }
        println("Liczba znalezionych obrazów: ${imageList.size}")
        return imageList
    }
}
