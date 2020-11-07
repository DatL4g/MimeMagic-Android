# MimeMagic-Android

[![Stars](https://img.shields.io/github/stars/DATL4G/MimeMagic-Android.svg)](https://github.com/DATL4G/MimeMagic-Android)

[![Forks](https://img.shields.io/github/forks/DATL4G/MimeMagic-Android.svg)](https://github.com/DATL4G/MimeMagic-Android)

[![License](https://img.shields.io/github/license/DATL4G/MimeMagic-Android.svg)](https://github.com/DATL4G/MimeMagic-Android)

MimeMagic-Android is an open source MimeType detector library for Android
* fetch MimeType by File, ByteArray, InputStream, Uri and Name
* uses fallback methods if fetching fails
* get prefix and suffix easily
* check if MimeType is Archive, Audio, Document, Font, Image, Text, Video

## Setup
Add this line in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
        ...
    }
}
  ```
Add this line in your app build.gradle:
```gradle
dependencies {
    ...
    implementation("com.github.DatL4g:MimeMagic-Android:1.0.1")
    ...
}
```

## Usage
Create MimeData Object using this static functions:
* ```fun fromFile(file: File)```
* ```fun fromFile(file: File, context: Context)```
* ```fun fromFile(file: File, contentResolver: ContentResolver)```
* ```fun fromByteArray(byteArray: ByteArray)```
* ```fun fromByteArray(byteArray: ByteArray, offset: Int)```
* ```fun fromByteArray(byteArray: ByteArray, offset: Int, length: Int)```
* ```fun fromInputStream(inputStream: InputStream)```
* ```fun fromUri(uri: Uri, context: Context)```
* ```fun fromUri(uri: Uri, context: Context, extension: String)```
* ```fun fromUri(uri: Uri, contentResolver: ContentResolver)```
* ```fun fromUri(uri: Uri, contentResolver: ContentResolver, extension: String)```
* ```fun fromExtension(extension: String)```
* ```fun fromName(name: String)```

#### Precision with fallback
You get the most exact MimeType when reading bytes.
So you should best use the functions: `fromFile`, `fromByteArray` and `fromInputStream`.
Reading the bytes does not always work and the MimeType is `null` then, to prevent this you can use a fallback method.
`fromFile` uses a fallback method under the hood, there are different types of method used depending on which parameters were passed.
To get the most precise MimeType with a good fallback method, I recommend `fromFile(file: File, context: Context)` or `fromFile(file: File, contentResolver: ContentResolver)`.
Less precise is `fromFile(file: File)` because it uses the MimeType that matches the extension as fallback.

#### Recommended method
```kotlin
val file = File("path/to/file.extension")
val mimeData = MimeData.fromFile(file, context)
// or
val mimeData = MimeData.fromFile(file, context.contentResolver)
```

#### Using extension functions
Available for:
* ByteArray
* ContentResolver
* Context
* File
* InputStream
* Uri

Example:
```kotlin
val file = File("path/to/file.extension")
val mimeData = file.getMimeData(context)
// or
val mimeData = file.getMimeData(context.contentResolver)
```

#### Handling MimeData Information
Available info:
* mimeType: String?
* delimiter: Char = '/'
* prefix: String?
* suffix: String?
* isApplication: Boolean
* isArchive: Boolean
* isAudio: Boolean
* isDocument: Boolean
* isFont: Boolean
* isImage: Boolean
* isText: Boolean
* isVideo: Boolean

#### Full Example
```kotlin
val file = File("path/to/file.extension")
val mimeData = MimeData.fromFile(file, context)

Log.e("TAG-MimeType", mimeData.mimeType)
Log.e("TAG-Mime is Image", mimeData.isImage.toString())
```

## Maintainers
This project is mantained by:
| Avatar | Contributor |
|---|:---:|
| [![](https://avatars3.githubusercontent.com/u/46448715?s=50&v=4)](http://github.com/DatL4g) | [DatLag](http://github.com/DatL4g) |

## Contributing

1. Fork it
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -m 'Add some feature')
5. Push your branch (git push origin my-new-feature)
6. Create a new Pull Request

## License

View full license [here](LICENSE). In short:

> A permissive license whose main conditions require preservation of copyright and license notices. Contributors provide an express grant of patent rights. Licensed works, modifications, and larger works may be distributed under different terms and without source code.

