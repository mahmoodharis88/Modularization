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
            id = "mutimodulesample.android.application"
            implementationClass = "plugins.AndroidAppConventionPlugin"
        }
        register("androidAppCompose") {
            id = "mutimodulesample.android.app.compose"
            implementationClass = "plugins.AndroidAppComposeConventionPlugin"
        }
        register("androidLibCompose") {
            id = "mutimodulesample.android.lib.compose"
            implementationClass = "plugins.AndroidLibComposeConventionPlugin"
        }
        register("androidLib") {
            id = "mutimodulesample.android.library"
            implementationClass = "plugins.AndroidLibConventionPlugin"
        }

        register("androidFeature") {
            id = "mutimodulesample.android.feature"
            implementationClass = "plugins.AndroidFeatureConventionPlugin"
        }

        register("hilt") {
            id = "mutimodulesample.android.hilt"
            implementationClass = "plugins.HiltConventionPlugin"
        }
    }
}