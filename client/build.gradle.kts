plugins {
    application
}

dependencies {
    implementation(project(":runescape"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

application {
    mainClass = "Application"
    applicationDefaultJvmArgs = listOf("-Xmx1024m", "-Dsun.java2d.noddraw=true")
}

tasks.named<Jar>("jar") {
    from(project(":runescape").sourceSets["main"].output) {
        into("runescape")  // This will place runescape's classes into the 'runescape' folder in the JAR
    }
    manifest {
    attributes["Main-Class"] = "Application"  // Replace with your main class
    }
}
