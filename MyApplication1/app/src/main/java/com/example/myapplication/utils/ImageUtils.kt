package com.example.myapplication.utils

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri

object ImageUtils {
    fun getScaledBitmapFromUri(contentResolver: ContentResolver, uri: Uri, width: Int, height: Int): Bitmap? {
        val inputStream = contentResolver.openInputStream(uri) ?: return null

        val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeStream(inputStream, null, options)

        val scaleFactor = Math.min(options.outWidth / width, options.outHeight / height)

        inputStream.close()
        val inputStreamForDecode = contentResolver.openInputStream(uri) ?: return null

        val scaledOptions = BitmapFactory.Options().apply { inSampleSize = scaleFactor }
        val bitmap = BitmapFactory.decodeStream(inputStreamForDecode, null, scaledOptions)
        inputStreamForDecode.close()

        return bitmap
    }
}

