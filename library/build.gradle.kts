import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(commonlibs.plugins.kotlin.multiplatform)
    alias(commonlibs.plugins.android.library)
    alias(commonlibs.plugins.kotlin.cocoapods)
}

group = commonlibs.versions.library.group.get()
version = commonlibs.versions.library.version.get()

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    val xcframeworkName = "piwikprokmp"
    val xcf = XCFramework(xcframeworkName)
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName
            binaryOption("bundleId", "io.github.remzoo.$xcframeworkName")
            xcf.add(this)
            isStatic = true
        }
    }

    cocoapods {
        version = "2.0"
        ios.deploymentTarget = "16.0"

        pod("PiwikPROSDK") {
            version = "2.1.1"
        }
    }

    sourceSets {
        androidMain {
            dependencies {
                implementation(commonlibs.piwik)
            }
        }

        commonMain {
            dependencies {
                implementation(commonlibs.kotlin.stdlib)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(commonlibs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "io.github.remzoo.piwikprokmp"
    compileSdk = commonlibs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = commonlibs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}