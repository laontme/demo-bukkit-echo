plugins {
    kotlin("jvm") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
}

defaultTasks("shadowJar")

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand(
                "name" to rootProject.name.capitalize(),
                "version" to project.version,
                "author" to project.property("author"),
                "description" to project.description,
                "api" to project.property("api"),
                "main" to "${project.group}.${rootProject.name}.${rootProject.name.capitalize()}"
            )
        }
    }

    jar {
        archiveClassifier.set("noshade")
    }

    shadowJar {
        archiveClassifier.set("")
    }
}