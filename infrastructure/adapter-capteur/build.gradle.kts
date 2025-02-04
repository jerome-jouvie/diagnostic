plugins {
    id("java-library")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":core"))

    implementation("org.slf4j:slf4j-api")
    implementation("org.springframework:spring-context")
}

tasks.bootJar {
    enabled = false
}
