plugins {
    kotlin("jvm") version "1.4.31"
    id("com.squareup.sqldelight") version "1.4.4"
}


group = "org.example"
version = "1.0-SNAPSHOT"

sqldelight {
    database("Database") { // This will be the name of the generated database class.
        packageName = "com.example"
        deriveSchemaFromMigrations = true
    }
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("com.squareup.sqldelight:sqlite-driver:1.4.4")
    val junitVersion = "5.7.1"
    val jupiterApi = "org.junit.jupiter:junit-jupiter-api:$junitVersion"
    val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$junitVersion"
    testImplementation(jupiterApi)
    testRuntimeOnly(jupiterEngine)
}

tasks {
    withType(Test::class.java) {
        useJUnitPlatform()
    }
}
