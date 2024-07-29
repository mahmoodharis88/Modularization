package plugins

import com.android.build.api.dsl.ApplicationExtension
import config.Config
import extensions.configureAndroidKotlin
import extensions.configureBuildTypes
import extensions.configureGradleManagedDevices
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidAppConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            apply(plugin ="com.android.application")
            apply(plugin ="kotlin-android")
            apply(plugin = "org.jetbrains.kotlin.plugin.compose")
            extensions.configure<ApplicationExtension> {
                configureAndroidKotlin(this)
                defaultConfig.targetSdk = Config.android.targetSdkVersion
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
                configureGradleManagedDevices(this)
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig.apply {
                    targetSdk = Config.android.targetSdkVersion

                }
                configureBuildTypes(this)
            }
        }
    }
}