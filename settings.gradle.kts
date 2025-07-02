pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

    versionCatalogs {
        create("commonlibs") {
            from(files("./gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "piwikprokmp"
include(":library")
