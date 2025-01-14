plugins {
    application
}

dependencies {
    implementation(project(":runescape"))
    implementation("org.bouncycastle:bcpkix-jdk18on:1.79")
    implementation("com.beust:jcommander:1.82")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainClass.set("RS2Loader") // Replace with your actual main class
    applicationDefaultJvmArgs = listOf("-Xmx1024m", "-Dsun.java2d.noddraw=true")
}

// Configure the JAR task to include dependencies
tasks.named<Jar>("jar") {
    from(sourceSets.main.get().output)

    // Include runtime dependencies while excluding META-INF
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    }) {
        exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
    }

    manifest {
        attributes["Main-Class"] = "RS2Loader" // Replace with your actual main class
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
