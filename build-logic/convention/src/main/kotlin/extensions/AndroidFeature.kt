package extensions

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidFeature(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
) {
    androidComponentsExtension.apply {

        dependencies {
            add("implementation", project(":core:ui"))
            add("implementation", project(":core:design-system"))

            add("implementation", versionCatalog().findLibrary("androidx.hilt.navigation.compose").get())
            add("implementation", versionCatalog().findLibrary("androidx.lifecycle.runtimeCompose").get())
            add("implementation", versionCatalog().findLibrary("androidx.lifecycle.viewModelCompose").get())
            add("implementation", versionCatalog().findLibrary("androidx.tracing.ktx").get())

            add("androidTestImplementation", versionCatalog().findLibrary("androidx.lifecycle.runtimeTesting").get())
        }

    }
}