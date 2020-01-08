package co.genui.spacegen

import java.text.SimpleDateFormat
import java.util.*

actual typealias DateTime = Date

actual val DateTime.toYMD: String
   get() = SimpleDateFormat("yyyy-MM-dd").format(this)

