package de.datlag.mimemagic.commons

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import de.datlag.mimemagic.MimeData

@JvmOverloads
fun Uri.getMimeData(context: Context, extension: String = MimeTypeMap.getFileExtensionFromUrl(this.toString())) = MimeData.fromUri(this, context, extension)

@JvmOverloads
fun Uri.getMimeData(contentResolver: ContentResolver, extension: String = MimeTypeMap.getFileExtensionFromUrl(this.toString())) = MimeData.fromUri(this, contentResolver, extension)