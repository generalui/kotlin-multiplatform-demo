package co.genui.spacegen

import android.graphics.Bitmap
import android.graphics.BitmapFactory

actual typealias NativeImage = Bitmap

actual fun nativeImageFromBytes(bytes: ByteArray): NativeImage? {
    val offset = 0
    return BitmapFactory.decodeByteArray(bytes, offset, bytes.size)
}
