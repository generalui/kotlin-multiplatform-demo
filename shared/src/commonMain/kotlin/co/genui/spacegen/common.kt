package co.genui.spacegen

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
  return "Kotlin rocks on ${platformName()}"
}
