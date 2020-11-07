package de.datlag.mimemagic

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import kotlin.jvm.Throws

data class MimeData(
    val mimeType: String?
) {

    val delimiter = '/'
    val prefix = mimeType?.split(delimiter)?.get(0)
    val suffix = mimeType?.split(delimiter)?.get(1)

    val isApplication: Boolean = prefix.equals(MimePrefix.APPLICATION, true)

    val isArchive: Boolean = isApplication && when (suffix) {
        MimeSuffix.UNIX_ARCHIVER -> true
        MimeSuffix.CPIO -> true
        MimeSuffix.SHELL_ARCHIVE -> true
        MimeSuffix.ISO_9660_IMAGE -> true
        MimeSuffix.SEQBOX -> true
        MimeSuffix.TAPE_ARCHIVE -> true
        MimeSuffix.BZIP2 -> true
        MimeSuffix.GZIP -> true
        MimeSuffix.LZIP -> true
        MimeSuffix.LZMA -> true
        MimeSuffix.LZOP -> true
        MimeSuffix.SNAPPY -> true
        MimeSuffix.XZ -> true
        MimeSuffix.DEFLATE -> true
        MimeSuffix.COMPRESS -> true
        MimeSuffix.Z_STANDARD -> true
        MimeSuffix.Z7 -> true
        MimeSuffix.Z7X -> true
        MimeSuffix.ACE -> true
        MimeSuffix.AFA -> true
        MimeSuffix.ALZIP -> true
        MimeSuffix.APK -> true
        MimeSuffix.ARC -> true
        MimeSuffix.FREE_ARC -> true
        MimeSuffix.ARJ -> true
        MimeSuffix.B1 -> true
        MimeSuffix.CABINET -> true
        MimeSuffix.COMPACT_FILE_SET -> true
        MimeSuffix.DISK_ARCHIVER -> true
        MimeSuffix.DGCA -> true
        MimeSuffix.APPLE_DISK_IMAGE -> true
        MimeSuffix.GCA -> true
        MimeSuffix.JAR -> true
        MimeSuffix.LHA -> true
        MimeSuffix.LZX -> true
        MimeSuffix.RAR -> true
        MimeSuffix.STUFF_IT -> true
        MimeSuffix.STUFF_IT_X -> true
        MimeSuffix.GZIP_TAR -> true
        MimeSuffix.WINDOWS_IMAGE -> true
        MimeSuffix.XAR -> true
        MimeSuffix.ZIP -> true
        MimeSuffix.ZOO -> true
        MimeSuffix.PAR2 -> true
        else -> false
    }

    val isAudio: Boolean = prefix.equals(MimePrefix.AUDIO, true)

    val isDocument: Boolean = isApplication && when (suffix) {
        MimeSuffix.DOC -> true
        MimeSuffix.DOT -> true
        MimeSuffix.DOCX -> true
        MimeSuffix.DOTX -> true
        MimeSuffix.DOCM -> true
        MimeSuffix.DOTM -> true
        MimeSuffix.XLS -> true
        MimeSuffix.XLT -> true
        MimeSuffix.XLA -> true
        MimeSuffix.XLSX -> true
        MimeSuffix.XLTX -> true
        MimeSuffix.XLSM -> true
        MimeSuffix.XLTM -> true
        MimeSuffix.XLAM -> true
        MimeSuffix.XLSB -> true
        MimeSuffix.PPT -> true
        MimeSuffix.POT -> true
        MimeSuffix.PPS -> true
        MimeSuffix.PPA -> true
        MimeSuffix.PPTX -> true
        MimeSuffix.POTX -> true
        MimeSuffix.PPSX -> true
        MimeSuffix.PPAM -> true
        MimeSuffix.PPTM -> true
        MimeSuffix.POTM -> true
        MimeSuffix.PPSM -> true
        MimeSuffix.MDB -> true
        MimeSuffix.ABI_WORD -> true
        MimeSuffix.ODP -> true
        MimeSuffix.ODS -> true
        MimeSuffix.ODT -> true
        MimeSuffix.VISIO -> true
        MimeSuffix.PDF -> true
        else -> false
    }

    val isFont: Boolean = prefix.equals(MimePrefix.FONT, true)

    val isImage: Boolean = prefix.equals(MimePrefix.IMAGE, true)

    val isText: Boolean = prefix.equals(MimePrefix.TEXT, true)

    val isVideo: Boolean = prefix.equals(MimePrefix.VIDEO, true)

    companion object {

        @Throws(IllegalArgumentException::class)
        fun fromFile(file: File): MimeData {
            if (file.isDirectory) {
                throw IllegalArgumentException("directories not allowed")
            }

            val guessType = Magic.guessContentType(file.inputStream())
            return if (guessType == null) {
                fromExtension(file.extension)
            } else {
                MimeData(guessType)
            }
        }

        @Throws(IllegalArgumentException::class)
        fun fromFile(file: File, context: Context): MimeData {
            if (file.isDirectory) {
                throw IllegalArgumentException("directories not allowed")
            }

            val guessType = Magic.guessContentType(file.inputStream())
            return if (guessType == null) {
                fromUri(Uri.fromFile(file), context)
            } else {
                MimeData(guessType)
            }
        }

        @Throws(IllegalArgumentException::class)
        fun fromFile(file: File, contentResolver: ContentResolver): MimeData {
            if (file.isDirectory) {
                throw IllegalArgumentException("directories not allowed")
            }

            val guessType = Magic.guessContentType(file.inputStream())
            return if (guessType == null) {
                fromUri(Uri.fromFile(file), contentResolver)
            } else {
                MimeData(guessType)
            }
        }

        @JvmOverloads
        fun fromByteArray(byteArray: ByteArray, offset: Int = 0, length: Int = byteArray.size): MimeData {
            return fromInputStream(ByteArrayInputStream(byteArray, offset, length))
        }

        fun fromInputStream(inputStream: InputStream) = MimeData(Magic.guessContentType(inputStream))

        @JvmOverloads
        fun fromUri(uri: Uri, contentResolver: ContentResolver, extension: String = MimeTypeMap.getFileExtensionFromUrl(uri.toString())): MimeData {
            return MimeData(Magic.getUriContentType(uri, contentResolver, extension))
        }

        @JvmOverloads
        fun fromUri(uri: Uri, context: Context, extension: String = MimeTypeMap.getFileExtensionFromUrl(uri.toString())) = fromUri(uri, context.contentResolver, extension)

        fun fromExtension(extension: String): MimeData {
            return MimeData(MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension))
        }

        fun fromName(name: String): MimeData {
            return fromExtension(name.substringAfterLast('.', ""))
        }
    }

}