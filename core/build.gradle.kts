plugins {
    id("java-library")
}

val junitVersion: String by project
val mockitoVersion: String by project
val assertJVersion: String by project

dependencies {
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-junit-jupiter:${mockitoVersion}")
    testImplementation("org.assertj:assertj-core:${assertJVersion}")
}