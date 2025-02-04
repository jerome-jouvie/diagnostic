plugins {
    base
    id("jacoco-report-aggregation")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    jacocoAggregation(project(":application"))
}

tasks {
    bootJar {
        enabled = false
    }
    check {
        dependsOn(named<JacocoReport>("testCodeCoverageReport"))
    }
}
