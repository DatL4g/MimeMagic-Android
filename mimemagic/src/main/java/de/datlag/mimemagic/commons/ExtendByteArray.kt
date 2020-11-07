package de.datlag.mimemagic.commons

import de.datlag.mimemagic.MimeData

@JvmOverloads
fun ByteArray.getMimeData(offset: Int = 0, length: Int = this.size) = MimeData.fromByteArray(this, offset, length)