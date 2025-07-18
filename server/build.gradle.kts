plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    application
}

group = "com.rvcoding.solotrek"
version = "1.0.0"
application {
    mainClass.set("com.rvcoding.solotrek.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    implementation(libs.koin.loggerSlf4j)
    implementation(libs.logback)
    implementation(libs.kotlinx.datetime)

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.serializationKotlinxJson)
    implementation(libs.ktor.server.callLogging)
    implementation(libs.ktor.server.statusPages)
    implementation(libs.ktor.server.contentNegotiation)
    implementation(libs.ktor.server.defaultHeaders)
    implementation(libs.ktor.server.htmlBuilder)
    implementation(libs.ktor.server.cors)

    implementation(libs.room.gradlePlugin)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.sqlite.bundled)

    implementation(project.dependencies.platform(libs.kotlincrypto.hash))
    implementation(libs.kotlincrypto.hash.sha2)

    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.junit)
    testImplementation(libs.assertk)
}

kotlin {
    jvmToolchain(17)
}

room {
    schemaDirectory("$projectDir/schemas")
}

tasks.test {
    useJUnitPlatform()
}
