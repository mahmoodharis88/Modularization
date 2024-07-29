package plugins

import com.android.build.gradle.api.AndroidBasePlugin
import extensions.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")
            dependencies {
                add("ksp", versionCatalog().findLibrary("hilt.compiler").get())
                add("implementation", versionCatalog().findLibrary("hilt.core").get())
            }

            /** Add support for Android modules, based on [AndroidBasePlugin] */
            pluginManager.withPlugin("com.android.base") {
                pluginManager.apply("dagger.hilt.android.plugin")
                dependencies {
                    add("implementation", versionCatalog().findLibrary("hilt.android").get())
                }
            }
        }
    }
}
