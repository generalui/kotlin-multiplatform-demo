package co.genui.spacegen

import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.memScoped
import platform.Foundation.NSData
import platform.Foundation.create
import platform.UIKit.UIImage

actual typealias NativeImage = UIImage

actual fun nativeImageFromBytes(bytes: ByteArray): NativeImage? {
    val data = bytes.toNSData()
    return UIImage.imageWithData(data)
}

private fun ByteArray.toNSData(): NSData = memScoped {
    NSData.create(bytes = allocArrayOf(this@toNSData),
        length = this@toNSData.size.toULong())
}
