plugins {
    id("org.jlleitschuh.gradle.ktlint").version("10.2.0")
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
    }
}
detekt {
    toolVersion = "1.10.0"
    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true
    failFast = true

    input = files("app/src/main/java", "app/src/main/kotlin")

    reports {
        html {
            enabled = true
            destination = file("app/build/detekt/detekt.html")
        }
    }
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.1")
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "io.gitlab.arturbosch.detekt")

}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}