plugins {
    id("java")
    id("jacoco")
}

val jacocoPluginVersion: String by project

allprojects {
    repositories {
        mavenCentral()
    }
}
subprojects {
    apply(plugin = "java")
    apply(plugin = "jacoco")

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    jacoco {
        toolVersion = jacocoPluginVersion
    }

    tasks {
        test {
            useJUnitPlatform()
            finalizedBy("jacocoTestReport")
        }
        jacocoTestReport {
            dependsOn(test)
            reports {
                xml.required.set(true)
                html.required.set(true)
            }
        }
    }
}
