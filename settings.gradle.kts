rootProject.name = "SpaceGen"

val kotlin_version: String by extra

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            val plugin = requested.id.id
            when (plugin) {
                "kotlinx-serialization" -> useModule("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")
            }
        }
    }
}

enableFeaturePreview("GRADLE_METADATA")

include("app")
include("shared")
