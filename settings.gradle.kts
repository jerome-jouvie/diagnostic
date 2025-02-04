rootProject.name = "diagnostic"

include(
    "application",
    "core",
    "infrastructure:adapter-capteur",
    "infrastructure:adapter-ecran")
include(
    "code-coverage-report")

pluginManagement {
    val springBootPluginVersion: String by settings
    val springDependencyManagementPluginVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootPluginVersion
        id("io.spring.dependency-management") version springDependencyManagementPluginVersion
    }
}