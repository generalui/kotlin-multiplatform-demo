package co.genui.spacegen

import platform.Foundation.*

actual typealias DateTime = NSDate

actual val DateTime.toYMD: String
   get() {
       val formatter = NSDateFormatter()
       formatter.dateFormat = "yyyy-MM-dd"
       return formatter.stringFromDate(this)
   }
