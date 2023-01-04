plugins {
    id("java")
    application
}

group = "stretz.loom"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<JavaExec> {
    jvmArgs?.add("--enable-preview")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "stretz.loom.Main"
    }
}

application {
    mainClass.set("stretz.loom.Main")
}