package de.datlag.mimemagic.commons

import de.datlag.mimemagic.MimeData
import java.io.InputStream

fun InputStream.getMimeData() = MimeData.fromInputStream(this)