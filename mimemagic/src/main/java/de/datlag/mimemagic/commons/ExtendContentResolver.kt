package de.datlag.mimemagic.commons

import android.content.ContentResolver
import android.net.Uri
import android.webkit.MimeTypeMap
import de.datlag.mimemagic.MimeData
import java.io.File

fun ContentResolver.getMimeData(file: File) = MimeData.fromFile(file, this)

fun ContentResolver.getMimeData(uri: Uri, extension: String = MimeTypeMap.getFileExtensionFromUrl(uri.toString())) = MimeData.fromUri(uri, this, extension)