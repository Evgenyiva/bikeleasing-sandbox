plugins {
    kotlin("jvm") version "2.1.20"
    application
}

group = "com.bikeleasing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // Testing
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.5.13")
    implementation("org.slf4j:slf4j-api:2.0.5")
}

application {
    mainClass.set("com.bikeleasing.biketrip.MainKt")
}

// Definition der verschiedenen Source-Sets für develop, staging und prod
// Jede Umgebung hat ihre eigenen Quell- und Ressourcenverzeichnisse
java {
    sourceSets {
        val main by getting

        // Source-Set für die Entwicklungsumgebung
        // Enthält spezifische Klassen und Ressourcen für die Entwicklung
        create("develop") {
            // Quell- und Ressourcenverzeichnisse für develop
            java.srcDir("src/develop/kotlin")
            resources.srcDir("src/develop/resources")

            // develop-Klassen überschreiben main-Klassen
            compileClasspath += main.output
            runtimeClasspath += main.output
        }

        create("staging") {
            java.srcDir("src/staging/kotlin")
            resources.srcDir("src/staging/resources")

            compileClasspath += main.output
            runtimeClasspath += main.output
        }

        create("prod") {
            java.srcDir("src/prod/kotlin")
            resources.srcDir("src/prod/resources")

            compileClasspath += main.output
            runtimeClasspath += main.output
        }
    }
}

tasks.register<JavaExec>("runDevelop") {
    classpath = sourceSets["develop"].runtimeClasspath
    mainClass.set("com.bikeleasing.biketrip.MainKt")
}

tasks.register<JavaExec>("runStaging") {
    classpath = sourceSets["staging"].runtimeClasspath
    mainClass.set("com.bikeleasing.biketrip.MainKt")
}

tasks.register<JavaExec>("runProd") {
    classpath = sourceSets["prod"].runtimeClasspath
    mainClass.set("com.bikeleasing.biketrip.MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
