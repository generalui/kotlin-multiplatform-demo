import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

val ktor_version: String by extra
val coroutines_version: String by extra
val serialization_version: String by extra
val sqldelight_version: String by extra

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("com.squareup.sqldelight")
}

android {
    compileSdkVersion(28)
    buildToolsVersion = "29.0.2"
    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(28)
    }
}

kotlin {
    //select iOS target platform depending on the Xcode environment variables
    val iOSTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iOSTarget("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    android()

    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutines_version")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serialization_version")
        // SQLITE
        implementation("com.squareup.sqldelight:runtime:$sqldelight_version")
    }

    sourceSets["androidMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serialization_version")
        // ANDROID
        api("com.android.support:support-compat:28.0.0")
        // SQLITE
        implementation("com.squareup.sqldelight:android-driver:$sqldelight_version")
    }

    sourceSets["iosMain"].dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutines_version")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serialization_version")
        // SQLITE
        implementation("com.squareup.sqldelight:ios-driver:$sqldelight_version")
    }

}

sqldelight {
  database("SpaceGenDB") {
    packageName = "com.genui.spacegen.db"
  }
}

val packForXcode by tasks.creating(Sync::class) {
    val targetDir = File(buildDir, "xcode-frameworks")

    /// selecting the right configuration for the iOS 
    /// framework depending on the environment
    /// variables set by Xcode build
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets
                          .getByName<KotlinNativeTarget>("ios")
                          .binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    from({ framework.outputDirectory })
    into(targetDir)

    /// generate a helpful ./gradlew wrapper with embedded Java path
    doLast {
        val gradlew = File(targetDir, "gradlew")
        gradlew.writeText("#!/bin/bash\n" 
            + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n" 
            + "cd '${rootProject.rootDir}'\n" 
            + "./gradlew \$@\n")
        gradlew.setExecutable(true)
    }
}

tasks.getByName("build").dependsOn(packForXcode)
