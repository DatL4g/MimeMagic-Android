package de.datlag.mimemagic.commons

import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import de.datlag.mimemagic.MimeData
import java.io.File

fun Context.getMimeData(file: File) = MimeData.fromFile(file, this)

@JvmOverloads
fun Context.getMimeData(uri: Uri, extension: String = MimeTypeMap.getFileExtensionFromUrl(uri.toString())) = MimeData.fromUri(uri, this, extension)