plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "4.0.4"
    id("maven-publish")
}

group = "es.angelillo15"
version = "1.4"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Carleslc.Simple-YAML:Simple-Yaml:1.8.3")
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
            version = "1.4"

            from(components["java"])
        }
    }
}
