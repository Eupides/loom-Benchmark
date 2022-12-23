plugins {
    id("java")
    application
}

group = "stretz.loom"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

application {
    mainClass.set("stretz.loom.Main")
}