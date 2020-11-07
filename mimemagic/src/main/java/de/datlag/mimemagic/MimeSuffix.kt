package de.datlag.mimemagic

object MimeSuffix {

    // Archives
    const val UNIX_ARCHIVER = "x-archive"
    const val CPIO = "x-cpio"
    const val SHELL_ARCHIVE = "x-shar"
    const val ISO_9660_IMAGE = "x-iso9660-image"
    const val SEQBOX = "x-sbx"
    const val TAPE_ARCHIVE = "x-tar"
    const val BZIP2 = "x-bzip2"
    const val GZIP = "gzip"
    const val LZIP = "x-lzip"
    const val LZMA = "x-lzma"
    const val LZOP = "x-lzop"
    const val SNAPPY = "x-snappy-framed"
    const val XZ = "x-xz"
    const val DEFLATE = "x-compress"
    const val COMPRESS = DEFLATE
    const val Z_STANDARD = "zstd"
    const val Z7 = "x-7z-compressed"        // 7z
    const val Z7X = Z7                      // 7zX
    const val ACE = "x-ace-compressed"
    const val AFA = "x-astrotite-afa"
    const val ALZIP = "x-alz-compressed"
    const val APK = "vnd.android.package-archive"
    const val ARC = "octet-stream"
    const val FREE_ARC = "x-freearc"
    const val ARJ = "x-arj"
    const val B1 = "x-b1"
    const val CABINET = "vnd.ms-cab-compressed"
    const val COMPACT_FILE_SET = "x-cfs-compressed"
    const val DISK_ARCHIVER = "x-dar"
    const val DGCA = "x-dgc-compressed"
    const val APPLE_DISK_IMAGE = "x-apple-diskimage"
    const val GCA = "x-gca-compressed"
    const val JAR = "java-archive"
    const val LHA = "x-lzh"
    const val LZX = "x-lzx"
    const val RAR = "x-rar-compressed"
    const val STUFF_IT = "x-stuffit"
    const val STUFF_IT_X = "x-stuffitx"
    const val GZIP_TAR = "x-gtar"
    const val WINDOWS_IMAGE = "x-ms-wim"
    const val XAR = "x-xar"
    const val ZIP = "zip"
    const val ZOO = "x-zoo"
    const val PAR2 = "x-par2"

    // Documents
    const val DOC = "msword"
    const val DOT = DOC
    const val DOCX = "vnd.openxmlformats-officedocument.wordprocessingml.document"
    const val DOTX = "vnd.openxmlformats-officedocument.wordprocessingml.template"
    const val DOCM = "vnd.ms-word.document.macroEnabled.12"
    const val DOTM = "vnd.ms-word.template.macroEnabled.12"
    const val XLS = "vnd.ms-excel"
    const val XLT = XLS
    const val XLA = XLS
    const val XLSX = "vnd.openxmlformats-officedocument.spreadsheetml.sheet"
    const val XLTX = "vnd.openxmlformats-officedocument.spreadsheetml.template"
    const val XLSM = "vnd.ms-excel.sheet.macroEnabled.12"
    const val XLTM = "vnd.ms-excel.template.macroEnabled.12"
    const val XLAM = "vnd.ms-excel.addin.macroEnabled.12"
    const val XLSB = "vnd.ms-excel.sheet.binary.macroEnabled.12"
    const val PPT = "vnd.ms-powerpoint"
    const val POT = PPT
    const val PPS = PPT
    const val PPA = PPT
    const val PPTX = "vnd.openxmlformats-officedocument.presentationml.presentation"
    const val POTX = "vnd.openxmlformats-officedocument.presentationml.template"
    const val PPSX = "vnd.openxmlformats-officedocument.presentationml.slideshow"
    const val PPAM = "vnd.ms-powerpoint.addin.macroEnabled.12"
    const val PPTM = "vnd.ms-powerpoint.presentation.macroEnabled.12"
    const val POTM = "vnd.ms-powerpoint.template.macroEnabled.12"
    const val PPSM = "vnd.ms-powerpoint.slideshow.macroEnabled.12"
    const val MDB = "vnd.ms-access"
    const val ABI_WORD = "x-abiword"
    const val ODP = "vnd.oasis.opendocument.presentation"
    const val ODS = "vnd.oasis.opendocument.spreadsheet"
    const val ODT = "vnd.oasis.opendocument.text"
    const val VISIO = "vnd.visio"
    const val PDF = "pdf"
}