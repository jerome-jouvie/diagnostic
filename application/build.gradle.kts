plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":infrastructure:adapter-ecran"))
    implementation(project(":infrastructure:adapter-capteur"))

    implementation("org.springframework.boot:spring-boot-starter")
}
