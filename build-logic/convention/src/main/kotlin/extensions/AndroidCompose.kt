package extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions.kotlinCompilerExtensionVersion =
            versionCatalog().findVersion("androidx-compose-compiler").get().toString()

        dependencies {
            add("implementation", versionCatalog().findLibrary("androidx-activity-compose").get())
            add(
                "implementation",
                platform(versionCatalog().findLibrary("androidx-compose-bom").get())
            )
            add("implementation", versionCatalog().findBundle("compose").get())
            add(
                "androidTestImplementation",
                platform(versionCatalog().findLibrary("androidx-compose-bom").get())
            )
            add("testImplementation", versionCatalog().findLibrary("androidx-ui-test-junit4").get())
            add("debugImplementation", versionCatalog().findLibrary("androidx-ui-tooling").get())
            add(
                "debugImplementation",
                versionCatalog().findLibrary("androidx-ui-test-manifest").get()
            )
        }
    }
}