plugins {
    application
}

dependencies {
    implementation project(':runescape')
    implementation(libs.bouncycastle.bcpkix)
    implementation(libs.jcommander)
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

tasks.withType(JavaExec) {
    workingDir = project.rootDir
}
