import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApp") {
            id = "blooddonation.android.application"
            implementationClass = "plugins.AndroidAppConventionPlugin"
        }
        register("androidAppCompose") {
            id = "blooddonation.android.app.compose"
            implementationClass = "plugins.AndroidAppComposeConventionPlugin"
        }
        register("androidLibCompose") {
            id = "blooddonation.android.lib.compose"
            implementationClass = "plugins.AndroidLibComposeConventionPlugin"
        }
        register("androidLib") {
            id = "blooddonation.android.library"
            implementationClass = "plugins.AndroidLibConventionPlugin"
        }

        register("androidFeature") {
            id = "blooddonation.android.feature"
            implementationClass = "plugins.AndroidFeatureConventionPlugin"
        }

        register("hilt") {
            id = "blooddonation.android.hilt"
            implementationClass = "plugins.HiltConventionPlugin"
        }
    }
}