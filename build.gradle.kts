plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "4.0.4"
    id("maven-publish")
}

group = "es.angelillo15"
version = "1.2"

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

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "es.angelillo15"
            artifactId = "ConfigManager"
            version = "1.2"

            from(components["java"])
        }
    }
}