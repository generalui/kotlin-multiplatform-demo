package co.genui.spacegen

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
  return "Kotlin rolls on ${platformName()}"
}
