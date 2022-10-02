plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("me.carleslc.Simple-YAML:Simple-Yaml:1.8.1")
    implementation("org.yaml:snakeyaml:1.32")
}

tasks.shadowJar {
    archiveFileName.set("ConfigManager.jar")
    relocate("org.simpleyaml", "es.angelillo15.minearte.libs.simpleyaml")
    relocate("org.yaml", "es.angelillo15.minearte.libs.yaml")
}