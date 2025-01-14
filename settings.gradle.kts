pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven(url = "https://repo.openrs2.org/repository/openrs2-snapshots")
    }
}

rootProject.name = "2011scape-client"

include(
    "client",
    "loader",
    "runescape",
)
