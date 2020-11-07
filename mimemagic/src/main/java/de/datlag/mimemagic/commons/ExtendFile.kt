package de.datlag.mimemagic.commons

import android.content.ContentResolver
import android.content.Context
import de.datlag.mimemagic.MimeData
import java.io.File

@JvmOverloads
fun File.getMimeData(context: Context? = null): MimeData {
    return if (context == null) {
        MimeData.fromFile(this)
    } else {
        MimeData.fromFile(this, context)
    }
}

fun File.getMimeData(contentResolver: ContentResolver): MimeData {
    return MimeData.fromFile(this, contentResolver)
}