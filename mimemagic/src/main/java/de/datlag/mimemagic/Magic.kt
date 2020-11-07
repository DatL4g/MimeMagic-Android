package de.datlag.mimemagic

import android.content.ContentResolver
import android.net.Uri
import android.os.Build
import android.webkit.MimeTypeMap
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.URLConnection
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

internal object Magic {

    fun guessContentType(inputStream: InputStream): String? {
        return try {
            URLConnection.guessContentTypeFromStream(if (inputStream is BufferedInputStream) inputStream else BufferedInputStream(inputStream))
        } catch (ignored: Exception) {
            null
        }
    }

    fun getUriContentType(uri: Uri, contentResolver: ContentResolver, extension: String): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val path = Paths.get(uri.toString())
            try {
                Files.probeContentType(path) ?: fallbackUriContentType(uri, contentResolver, extension)
            } catch (ignored: Exception) {
                fallbackUriContentType(uri, contentResolver, extension)
            }
        } else {
            fallbackUriContentType(uri, contentResolver, extension)
        }
    }

    private fun fallbackUriContentType(uri: Uri, contentResolver: ContentResolver, extension: String): String? {
        return if (uri.scheme == ContentResolver.SCHEME_CONTENT) {
            contentResolver.getType(uri)
        } else {
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase(Locale.getDefault()))
        }
    }

}